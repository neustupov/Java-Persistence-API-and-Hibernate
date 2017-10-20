package ru.neustupov.model.helloworld;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class HelloWorldJPA {

    public static void main(String[] args) {

        // Start EntityManagerFactory
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("HelloWorldPU");

        // Save Message
        // Create EntityManager, create transaction
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        // Create message, save message
        Message message = new Message();
        message.setText("Hello World with JPA");
        em.persist(message);

        // Close transaction and entityManager
        tx.commit();
        em.close();

        // Load Messages
        // Create new EntityManager and Transaction
        EntityManager newEm = emf.createEntityManager();
        EntityTransaction newTx = newEm.getTransaction();
        newTx.begin();

        // Load list of Messages
        List messages =
                newEm.createQuery("select m from Message m").getResultList(); // SELECT * from MESSAGE

        System.out.println( messages.size() + " message(s) found:" );

        messages.forEach(System.out::print);

        newTx.commit();
        newEm.close();

        // Shutting down the application
        emf.close();
    }
}