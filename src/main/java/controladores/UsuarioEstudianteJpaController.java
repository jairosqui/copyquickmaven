/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Entidades.UsuarioEstudiante;
import controladores.exceptions.NonexistentEntityException;
import controladores.exceptions.RollbackFailureException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.UserTransaction;

/**
 *
 * @author Asus
 */
public class UsuarioEstudianteJpaController implements Serializable {

    public UsuarioEstudianteJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsuarioEstudiante usuarioEstudiante) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(usuarioEstudiante);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UsuarioEstudiante usuarioEstudiante) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            usuarioEstudiante = em.merge(usuarioEstudiante);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuarioEstudiante.getIdUsuarioEstudiante();
                if (findUsuarioEstudiante(id) == null) {
                    throw new NonexistentEntityException("The usuarioEstudiante with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            UsuarioEstudiante usuarioEstudiante;
            try {
                usuarioEstudiante = em.getReference(UsuarioEstudiante.class, id);
                usuarioEstudiante.getIdUsuarioEstudiante();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioEstudiante with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuarioEstudiante);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UsuarioEstudiante> findUsuarioEstudianteEntities() {
        return findUsuarioEstudianteEntities(true, -1, -1);
    }

    public List<UsuarioEstudiante> findUsuarioEstudianteEntities(int maxResults, int firstResult) {
        return findUsuarioEstudianteEntities(false, maxResults, firstResult);
    }

    private List<UsuarioEstudiante> findUsuarioEstudianteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioEstudiante.class));
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

    public UsuarioEstudiante findUsuarioEstudiante(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioEstudiante.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioEstudianteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsuarioEstudiante> rt = cq.from(UsuarioEstudiante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
