package ru.neustupov.model.simple;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

  @Id
  @GeneratedValue
  private Long id;
  protected String username;

  public User() {
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public BigDecimal calcShippingCosts(Address fromLocation){
    return null;
  }
}
