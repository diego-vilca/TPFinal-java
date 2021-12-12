/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import logica.ServicioTuristico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.PaqueteTuristico;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Diego
 */
public class PaqueteTuristicoJpaController implements Serializable {

    public PaqueteTuristicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    //agrego el constructor para mi unidad de persistencia y conección con mi controladora de JPA
    public PaqueteTuristicoJpaController() {
        emf = Persistence.createEntityManagerFactory("TpFinalPU");
    }
       
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PaqueteTuristico paqueteTuristico) {
        if (paqueteTuristico.getListaServicios() == null) {
            paqueteTuristico.setListaServicios(new ArrayList<ServicioTuristico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<ServicioTuristico> attachedListaServicios = new ArrayList<ServicioTuristico>();
            for (ServicioTuristico listaServiciosServicioTuristicoToAttach : paqueteTuristico.getListaServicios()) {
                listaServiciosServicioTuristicoToAttach = em.getReference(listaServiciosServicioTuristicoToAttach.getClass(), listaServiciosServicioTuristicoToAttach.getCodigo());
                attachedListaServicios.add(listaServiciosServicioTuristicoToAttach);
            }
            paqueteTuristico.setListaServicios(attachedListaServicios);
            em.persist(paqueteTuristico);
            for (ServicioTuristico listaServiciosServicioTuristico : paqueteTuristico.getListaServicios()) {
                listaServiciosServicioTuristico.getListaPaquetes().add(paqueteTuristico);
                listaServiciosServicioTuristico = em.merge(listaServiciosServicioTuristico);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PaqueteTuristico paqueteTuristico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PaqueteTuristico persistentPaqueteTuristico = em.find(PaqueteTuristico.class, paqueteTuristico.getCodigoPaquete());
            List<ServicioTuristico> listaServiciosOld = persistentPaqueteTuristico.getListaServicios();
            List<ServicioTuristico> listaServiciosNew = paqueteTuristico.getListaServicios();
            List<ServicioTuristico> attachedListaServiciosNew = new ArrayList<ServicioTuristico>();
            for (ServicioTuristico listaServiciosNewServicioTuristicoToAttach : listaServiciosNew) {
                listaServiciosNewServicioTuristicoToAttach = em.getReference(listaServiciosNewServicioTuristicoToAttach.getClass(), listaServiciosNewServicioTuristicoToAttach.getCodigo());
                attachedListaServiciosNew.add(listaServiciosNewServicioTuristicoToAttach);
            }
            listaServiciosNew = attachedListaServiciosNew;
            paqueteTuristico.setListaServicios(listaServiciosNew);
            paqueteTuristico = em.merge(paqueteTuristico);
            for (ServicioTuristico listaServiciosOldServicioTuristico : listaServiciosOld) {
                if (!listaServiciosNew.contains(listaServiciosOldServicioTuristico)) {
                    listaServiciosOldServicioTuristico.getListaPaquetes().remove(paqueteTuristico);
                    listaServiciosOldServicioTuristico = em.merge(listaServiciosOldServicioTuristico);
                }
            }
            for (ServicioTuristico listaServiciosNewServicioTuristico : listaServiciosNew) {
                if (!listaServiciosOld.contains(listaServiciosNewServicioTuristico)) {
                    listaServiciosNewServicioTuristico.getListaPaquetes().add(paqueteTuristico);
                    listaServiciosNewServicioTuristico = em.merge(listaServiciosNewServicioTuristico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = paqueteTuristico.getCodigoPaquete();
                if (findPaqueteTuristico(id) == null) {
                    throw new NonexistentEntityException("The paqueteTuristico with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PaqueteTuristico paqueteTuristico;
            try {
                paqueteTuristico = em.getReference(PaqueteTuristico.class, id);
                paqueteTuristico.getCodigoPaquete();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paqueteTuristico with id " + id + " no longer exists.", enfe);
            }
            List<ServicioTuristico> listaServicios = paqueteTuristico.getListaServicios();
            for (ServicioTuristico listaServiciosServicioTuristico : listaServicios) {
                listaServiciosServicioTuristico.getListaPaquetes().remove(paqueteTuristico);
                listaServiciosServicioTuristico = em.merge(listaServiciosServicioTuristico);
            }
            em.remove(paqueteTuristico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PaqueteTuristico> findPaqueteTuristicoEntities() {
        return findPaqueteTuristicoEntities(true, -1, -1);
    }

    public List<PaqueteTuristico> findPaqueteTuristicoEntities(int maxResults, int firstResult) {
        return findPaqueteTuristicoEntities(false, maxResults, firstResult);
    }

    private List<PaqueteTuristico> findPaqueteTuristicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PaqueteTuristico.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public PaqueteTuristico findPaqueteTuristico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PaqueteTuristico.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaqueteTuristicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PaqueteTuristico> rt = cq.from(PaqueteTuristico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
