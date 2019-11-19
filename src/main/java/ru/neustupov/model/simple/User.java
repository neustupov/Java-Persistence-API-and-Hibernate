package ru.neustupov.model.simple;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User implements Serializable {

  @Id
  @GeneratedValue(generator = "ID_GENERATOR")
  private Long id;

  protected String username;

  private String firstname;

  private String lastname;

  private Address homeAddress;

  @AttributeOverrides({
      @AttributeOverride(
          name = "street", column = @Column(name = "BILLING_STREET")
      ),
      @AttributeOverride(
          name = "zipcode", column = @Column(name = "BILLING_ZIPCODE")
      ),
      @AttributeOverride(
          name = "city", column = @Column(name = "BILLING_CITY")
      )
  })
  private Address billingAddress;

  public User() {
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public BigDecimal calcShippingCosts(Address fromLocation){
    return null;
  }

  public Address getHomeAddress() {
    return homeAddress;
  }

  public void setHomeAddress(Address homeAddress) {
    this.homeAddress = homeAddress;
  }
}
