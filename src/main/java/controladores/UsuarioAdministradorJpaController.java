/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import Entidades.UsuarioAdministrador;
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
public class UsuarioAdministradorJpaController implements Serializable {

    public UsuarioAdministradorJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UsuarioAdministrador usuarioAdministrador) throws RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            em.persist(usuarioAdministrador);
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

    public void edit(UsuarioAdministrador usuarioAdministrador) throws NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            usuarioAdministrador = em.merge(usuarioAdministrador);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = usuarioAdministrador.getIdUsuarioAdministrador();
                if (findUsuarioAdministrador(id) == null) {
                    throw new NonexistentEntityException("The usuarioAdministrador with id " + id + " no longer exists.");
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
            UsuarioAdministrador usuarioAdministrador;
            try {
                usuarioAdministrador = em.getReference(UsuarioAdministrador.class, id);
                usuarioAdministrador.getIdUsuarioAdministrador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The usuarioAdministrador with id " + id + " no longer exists.", enfe);
            }
            em.remove(usuarioAdministrador);
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

    public List<UsuarioAdministrador> findUsuarioAdministradorEntities() {
        return findUsuarioAdministradorEntities(true, -1, -1);
    }

    public List<UsuarioAdministrador> findUsuarioAdministradorEntities(int maxResults, int firstResult) {
        return findUsuarioAdministradorEntities(false, maxResults, firstResult);
    }

    private List<UsuarioAdministrador> findUsuarioAdministradorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UsuarioAdministrador.class));
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

    public UsuarioAdministrador findUsuarioAdministrador(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UsuarioAdministrador.class, id);
        } finally {
            em.close();
        }
    }

    public int getUsuarioAdministradorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UsuarioAdministrador> rt = cq.from(UsuarioAdministrador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
