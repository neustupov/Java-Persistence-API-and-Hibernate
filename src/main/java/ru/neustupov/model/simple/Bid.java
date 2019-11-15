package ru.neustupov.model.simple;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class Bid {

  @Id
  @GeneratedValue(generator = "ID_GENERATOR")
  private Long id;

  private BigDecimal amount;

  private Date createdOn;

  private Item item;

  public Bid() {
  }

  public Bid(Item item) {
    this.item = item;
    item.getBids().add(this);
  }

  public Long getId() {
    return id;
  }

  public Item getItem() {
    return item;
  }

  protected void setItem(Item item) {
    this.item = item;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }
}
