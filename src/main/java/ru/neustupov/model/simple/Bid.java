package ru.neustupov.model.simple;

import javax.persistence.Entity;

@Entity
public class Bid {

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
