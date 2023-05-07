package Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides utility methods for working with Hibernate, including getting a SessionFactory instance,
 *  saving objects to the database, and retrieving objects from the database.
 */
public class HibernateUtil {
    private static StandardServiceRegistry registry;
    private static SessionFactory sessionFactory;

    /**
     * Gets a SessionFactory instance, creating one if it does not already exist.
     * @return The SessionFactory instance
     */
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                registry = new StandardServiceRegistryBuilder().configure().build();
                MetadataSources sources = new MetadataSources(registry);
                Metadata metadata = sources.getMetadataBuilder().build();
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    /**
     * Shuts down the registry and closes the session factory.
     */
    public static void shutdown() {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    /**
     * Saves a list of entities to the database.
     * @param entities The list of entities to save.
     * @throws Exception If there is an error saving the entities to the database.
     */
    public static <T> void saveToDatabase(List<T> entities) throws Exception {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            for (T entity : entities) {
                session.saveOrUpdate(entity);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new Exception(e.toString());
        }
    }

    /**
     * Retrieves a list of entities of a specified class from the database.
     * @param entityClass The class of the entities to retrieve.
     * @return The list of entities retrieved from the database.
     * @throws Exception If there is an error retrieving the entities from the database.
     */
    public static <T> List<T> getFromDatabase(Class<T> entityClass) {
        List<T> entities = new ArrayList<>();
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            entities = session.createQuery("from " + entityClass.getSimpleName(), entityClass).list();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw e;
        }
        return entities;
    }
}

