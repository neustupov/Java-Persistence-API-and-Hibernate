package ru.neustupov.model.advanced;

import javax.persistence.Entity;
import javax.persistence.Id;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;
import org.hibernate.annotations.Synchronize;

@Entity
@Immutable
@Subselect(value = "select i.ID as ITEMID, i.NAME as NAME, count(b.ID) as NUMBEROFBIDS " +
                   "from ITEM i left outer join BID b on i.ID = b.ITEM_ID " +
                   "group by i.ID, i.NAME")
@Synchronize({"Item", "Bid"})
public class ItemBidSummary {

  @Id
  private Long itemId;

  private String name;

  private long numberOfBids;

  public ItemBidSummary() {
  }

  public Long getItemId() {
    return itemId;
  }

  public String getName() {
    return name;
  }

  public long getNumberOfBids() {
    return numberOfBids;
  }

  @Override
  public String toString() {
    return "ItemBidSummary{" +
        "itemId=" + itemId +
        ", name='" + name + '\'' +
        ", numberOfBids=" + numberOfBids +
        '}';
  }
}
