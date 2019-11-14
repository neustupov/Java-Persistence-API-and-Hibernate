package ru.neustupov.model.simple;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Item {

  @Id
  @GeneratedValue
  private Long id;

  @NotNull
  @Size(
      min = 2,
      max = 255,
      message = "min = 2, max = 255"
  )
  protected String name;

  private BigDecimal initialPrice;

  @Future
  protected Date auctionEnd;

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

  public BigDecimal getInitialPrice() {
    return initialPrice;
  }

  public void setInitialPrice(BigDecimal initialPrice) {
    this.initialPrice = initialPrice;
  }
}
