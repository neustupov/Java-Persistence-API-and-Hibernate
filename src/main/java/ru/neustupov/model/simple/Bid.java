package ru.neustupov.model.simple;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
public class Bid {

  @Id
  @GeneratedValue(generator = "ID_GENERATOR")
  private Long id;

  private BigDecimal amount;

  private Date createdOn;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(insertable = false, updatable = false)
  @Generated(GenerationTime.ALWAYS)
  private Date lastModified;

  @ManyToOne(fetch= FetchType.EAGER)
  private Item item;

  public Bid() {
  }

  public Bid(Item item) {
    this.item = item;
    item.getBids().add(this);
  }

  public Bid(BigDecimal amount, Date createdOn, Item item) {
    this.amount = amount;
    this.createdOn = createdOn;
    this.item = item;
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
