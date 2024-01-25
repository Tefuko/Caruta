package com.caruta.kn.enums;

public enum MessageType {
  SUCCESS("S", "success"),
  INFO("I", "info"),
  WARNING("W", "warning"),
  DANGER("E", "danger");

  private String type;
  private String typeName;

  private MessageType(String type, String typeName) {
    this.type = type;
    this.typeName = typeName;
  }

  public String getType() {
    return type;
  }

  public String getTypeName() {
    return typeName;
  }
}
