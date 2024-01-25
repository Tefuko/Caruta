package com.caruta.kn.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Response<T> implements Serializable {

  private List<Message> messages;
  private T responseBody;

  public void addMessage(Message message) {
    if (this.messages == null) {
      this.messages = new ArrayList<Message>();
    }
    this.messages.add(message);
  }
}
