package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;

import dao.interfaces.IClientDao;
import models.Client;
import utils.JPAUtil;

public class ClientDao extends GenericDao<Client, Long> implements IClientDao {
    public ClientDao() {
        super(Client.class);
    }

    /**
     * Finds a client by their email address.
     *
     * @param email the email address of the client to find
     * @return the Client object if found, or null if no client with the given email exists
     */
    public Client findByEmail(String email) {
        EntityManager em = JPAUtil.getEntityManager();

        try {
            String jpql = "SELECT c FROM Client c WHERE c.email = :email";
            return em.createQuery(jpql, Client.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // No client found with the given email
        } finally {
            em.close();
        }
    }
}
