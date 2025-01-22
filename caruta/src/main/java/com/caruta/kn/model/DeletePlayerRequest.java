package com.caruta.kn.model;

import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotEmpty;

@Data
public class DeletePlayerRequest {

  // 姓
  @NotEmpty(message = "「姓」は必須項目です")
  @Size(min = 0, max = 255, message = "「姓」は255文字以下でなければなりません")
  private String lastName;

  // 名
  @NotEmpty(message = "「名」は必須項目です")
  @Size(min = 0, max = 255, message = "「名」は255文字以下でなければなりません")
  private String firstName;

  // 電話番号
  @NotEmpty(message = "「電話番号」は必須項目です")
  @Size(min = 0, max = 20, message = "「電話番号」は20文字以下でなければなりません")
  private String telephoneNumber;
}