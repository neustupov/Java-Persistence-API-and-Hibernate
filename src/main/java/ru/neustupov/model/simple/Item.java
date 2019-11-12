package ru.neustupov.model.simple;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Item {

  private Set<Bid> bids = new HashSet<>();

  public Set<Bid> getBids() {
    return Collections.unmodifiableSet(bids);
  }

  public void addBid(Bid bid){
    if (bid == null){
      throw new NullPointerException("Null bid");
    }
    if (bid.getItem() != null){
      throw new IllegalStateException("Bid is already assigned to an Item");
    }
    getBids().add(bid);
    bid.setItem(this);
  }
}
