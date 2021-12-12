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
import logica.PaqueteTuristico;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import logica.ServicioTuristico;
import persistencia.exceptions.NonexistentEntityException;

/**
 *
 * @author Diego
 */
public class ServicioTuristicoJpaController implements Serializable {

    public ServicioTuristicoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    //agrego el constructor para mi unidad de persistencia y conección con mi controladora de JPA
    public ServicioTuristicoJpaController() {
        emf = Persistence.createEntityManagerFactory("TpFinalPU");
    }
        
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ServicioTuristico servicioTuristico) {
        if (servicioTuristico.getListaPaquetes() == null) {
            servicioTuristico.setListaPaquetes(new ArrayList<PaqueteTuristico>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<PaqueteTuristico> attachedListaPaquetes = new ArrayList<PaqueteTuristico>();
            for (PaqueteTuristico listaPaquetesPaqueteTuristicoToAttach : servicioTuristico.getListaPaquetes()) {
                listaPaquetesPaqueteTuristicoToAttach = em.getReference(listaPaquetesPaqueteTuristicoToAttach.getClass(), listaPaquetesPaqueteTuristicoToAttach.getCodigoPaquete());
                attachedListaPaquetes.add(listaPaquetesPaqueteTuristicoToAttach);
            }
            servicioTuristico.setListaPaquetes(attachedListaPaquetes);
            em.persist(servicioTuristico);
            for (PaqueteTuristico listaPaquetesPaqueteTuristico : servicioTuristico.getListaPaquetes()) {
                listaPaquetesPaqueteTuristico.getListaServicios().add(servicioTuristico);
                listaPaquetesPaqueteTuristico = em.merge(listaPaquetesPaqueteTuristico);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ServicioTuristico servicioTuristico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ServicioTuristico persistentServicioTuristico = em.find(ServicioTuristico.class, servicioTuristico.getCodigo());
            List<PaqueteTuristico> listaPaquetesOld = persistentServicioTuristico.getListaPaquetes();
            List<PaqueteTuristico> listaPaquetesNew = servicioTuristico.getListaPaquetes();
            List<PaqueteTuristico> attachedListaPaquetesNew = new ArrayList<PaqueteTuristico>();
            for (PaqueteTuristico listaPaquetesNewPaqueteTuristicoToAttach : listaPaquetesNew) {
                listaPaquetesNewPaqueteTuristicoToAttach = em.getReference(listaPaquetesNewPaqueteTuristicoToAttach.getClass(), listaPaquetesNewPaqueteTuristicoToAttach.getCodigoPaquete());
                attachedListaPaquetesNew.add(listaPaquetesNewPaqueteTuristicoToAttach);
            }
            listaPaquetesNew = attachedListaPaquetesNew;
            servicioTuristico.setListaPaquetes(listaPaquetesNew);
            servicioTuristico = em.merge(servicioTuristico);
            for (PaqueteTuristico listaPaquetesOldPaqueteTuristico : listaPaquetesOld) {
                if (!listaPaquetesNew.contains(listaPaquetesOldPaqueteTuristico)) {
                    listaPaquetesOldPaqueteTuristico.getListaServicios().remove(servicioTuristico);
                    listaPaquetesOldPaqueteTuristico = em.merge(listaPaquetesOldPaqueteTuristico);
                }
            }
            for (PaqueteTuristico listaPaquetesNewPaqueteTuristico : listaPaquetesNew) {
                if (!listaPaquetesOld.contains(listaPaquetesNewPaqueteTuristico)) {
                    listaPaquetesNewPaqueteTuristico.getListaServicios().add(servicioTuristico);
                    listaPaquetesNewPaqueteTuristico = em.merge(listaPaquetesNewPaqueteTuristico);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = servicioTuristico.getCodigo();
                if (findServicioTuristico(id) == null) {
                    throw new NonexistentEntityException("The servicioTuristico with id " + id + " no longer exists.");
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
            ServicioTuristico servicioTuristico;
            try {
                servicioTuristico = em.getReference(ServicioTuristico.class, id);
                servicioTuristico.getCodigo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicioTuristico with id " + id + " no longer exists.", enfe);
            }
            List<PaqueteTuristico> listaPaquetes = servicioTuristico.getListaPaquetes();
            for (PaqueteTuristico listaPaquetesPaqueteTuristico : listaPaquetes) {
                listaPaquetesPaqueteTuristico.getListaServicios().remove(servicioTuristico);
                listaPaquetesPaqueteTuristico = em.merge(listaPaquetesPaqueteTuristico);
            }
            em.remove(servicioTuristico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ServicioTuristico> findServicioTuristicoEntities() {
        return findServicioTuristicoEntities(true, -1, -1);
    }

    public List<ServicioTuristico> findServicioTuristicoEntities(int maxResults, int firstResult) {
        return findServicioTuristicoEntities(false, maxResults, firstResult);
    }

    private List<ServicioTuristico> findServicioTuristicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ServicioTuristico.class));
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

    public ServicioTuristico findServicioTuristico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ServicioTuristico.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicioTuristicoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ServicioTuristico> rt = cq.from(ServicioTuristico.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
