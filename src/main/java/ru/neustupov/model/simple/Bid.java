package ru.neustupov.model.simple;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bid {

  @Id
  @GeneratedValue
  private Long id;
  private Item item;

  public Bid() {
  }

  public Bid(Item item) {
    this.item = item;
    item.getBids().add(this);
  }

  public Item getItem() {
    return item;
  }

  protected void setItem(Item item) {
    this.item = item;
  }
}
