package ru.neustupov.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.neustupov.model.advanced.ItemBidSummary;
import ru.neustupov.model.simple.Bid;
import ru.neustupov.model.simple.Item;
import ru.neustupov.util.HibernateUtil;

public class MappedSubselect {

  @BeforeEach
  void setUp() {
    Item item = new Item("one");
    Bid bid1 = new Bid(new BigDecimal(1), new Date(), item);
    Bid bid2 = new Bid(new BigDecimal(2), new Date(), item);
    Transaction transaction = null;
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      // start a transaction
      transaction = session.beginTransaction();
      // save objects
      session.save(item);
      session.save(bid1);
      session.save(bid2);
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
  void mappedSubselect() {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
      ItemBidSummary itemBidSummary = session.find(ItemBidSummary.class, 1L);
      assertEquals(itemBidSummary.getName(), "one");
      assertEquals(itemBidSummary.getNumberOfBids(),2L);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
