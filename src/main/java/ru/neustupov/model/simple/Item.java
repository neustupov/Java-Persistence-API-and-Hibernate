package ru.neustupov.model.simple;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import ru.neustupov.model.advanced.MonetaryAmount;

@Entity
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@DynamicInsert
@DynamicUpdate
public class Item {

  @Id
  @GeneratedValue(generator = "ID_GENERATOR")
  private Long id;

  @NotNull
  @Size(
      min = 2,
      max = 255,
      message = "min = 2, max = 255"
  )
  protected String name;

  private BigDecimal initialPrice;

  @Column(name = "IMPERIALWEIGHT")
  @ColumnTransformer(
      read = "IMPERIALWEIGHT / 2.20462",
      write = "? * 2.20462"
  )
  private Double metricWeight;

  @Future
  protected Date auctionEnd;

  @Column(name = "PRICE", length = 63)
  protected MonetaryAmount buyNowPrice;

  @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, mappedBy = "item")
  private Set<Bid> bids = new HashSet<>();

  public Item() {
  }

  public Item(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

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
