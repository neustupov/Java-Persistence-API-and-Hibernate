package ru.neustupov.model.inheritance.mappedsuperclass;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class CreditCard extends BillingDetails {

  @NotNull
  private String cardNumber;

  @NotNull
  private String expMonth;

  @NotNull
  private String expYear;
}
