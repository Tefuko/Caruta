package com.caruta.kn.utils;

import java.util.ResourceBundle;
import lombok.Getter;

@Getter
public class ApplicationException extends Exception {
  private String errorCode;

  public ApplicationException(String errorCode) {
    super(getErrorMessage(errorCode));
    this.errorCode = errorCode;
  }

  private static String getErrorMessage(String errorCode) {
    ResourceBundle messages = ResourceBundle.getBundle("messages");
    return messages.getString(errorCode);
  }
}
