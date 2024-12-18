package com.caruta.kn.model;

import lombok.Data;

@Data
public class DeletePlayerRequest {

  // 姓
  private String lastName;

  // 名
  private String firstName;

  // 電話番号
  private String telephoneNumber;
}