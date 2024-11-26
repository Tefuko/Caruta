package com.caruta.kn.model;

import lombok.Data;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Data
public class AddPlayerRequest {

  // 姓
  private String lastName;

  // 名
  private String firstName;

  // 姓ふりがな
  private String lastNameKana;

  // 名ふりがな
  private String firstNameKana;

  // 郵便番号
  @Size(min = 7, max = 7, message = "郵便番号は7文字でなければなりません")
  @Pattern(regexp = "\\d{7}", message = "郵便番号は7桁の数字である必要があります")
  private String postalCode;

  // 住所
  private String address;

  // 生年月日
  private String birthday;

  // 電話番号
  private String telephoneNumber;

  // メールアドレス
  private String email;

  // 段
  private String rank;

  // 会員種別
  private String membershipType;

  // 所属会名
  private String associationName;
}
