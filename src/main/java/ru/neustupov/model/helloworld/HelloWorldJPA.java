package ru.neustupov.model.helloworld;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.neustupov.util.HibernateUtil;

public class HelloWorldJPA {

    public static void main(String[] args) {

        // Create message, save message
        Message message = new Message();
        message.setText("Hello World with JPA");

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save objects
            session.save(message);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List < Message > messages = session.createQuery("from Message", Message.class).list();
            messages.forEach(s -> System.out.println(s.getText()));
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}