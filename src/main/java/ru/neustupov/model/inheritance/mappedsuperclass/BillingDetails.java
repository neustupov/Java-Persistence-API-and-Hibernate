package ru.neustupov.model.inheritance.mappedsuperclass;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class BillingDetails {

  @NotNull
  private String owner;

  public String getOwner() {
    return owner;
  }
}
