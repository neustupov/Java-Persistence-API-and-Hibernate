package ru.neustupov.model.inheritance.mappedsuperclass;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@AttributeOverride(
    name = "owner",
    column = @Column(name = "CC_OWNER", nullable = false)
)
public class CreditCard extends BillingDetails {

  @Id
  @GeneratedValue(generator = "ID_GENERATOR")
  private Long id;

  @NotNull
  private String cardNumber;

  @NotNull
  private String expMonth;

  @NotNull
  private String expYear;
}
