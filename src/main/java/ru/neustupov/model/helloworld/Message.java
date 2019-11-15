package ru.neustupov.model.helloworld;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Message {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;

    private String text;

    public Message() {
    }

  public Long getId() {
    return id;
  }

  public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
