package ru.neustupov.model.simple;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Address {

  @NotNull
  @Column(nullable = false)
  private String street;

  @NotNull
  @Column(nullable = false, length = 5)
  private String zipcode;

  @NotNull
  @Column(nullable = false)
  private String city;

  public Address() {
  }

  public Address(@NotNull String street,
      @NotNull String zipcode, @NotNull String city) {
    this.street = street;
    this.zipcode = zipcode;
    this.city = city;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
