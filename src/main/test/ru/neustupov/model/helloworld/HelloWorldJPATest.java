package ru.neustupov.model.helloworld;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.neustupov.util.HibernateUtil;

class HelloWorldJPATest {

  @BeforeEach
  void setUp() {
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
  }

  @Test
  void main() {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      List< Message > messages = session.createQuery("from Message", Message.class).list();
      messages.forEach(s -> System.out.println(s.getText()));
      assertEquals(messages.size(), 1);
      assertEquals(messages.get(0).getText(),"Hello World with JPA");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}