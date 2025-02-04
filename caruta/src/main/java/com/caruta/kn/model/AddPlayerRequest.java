package com.caruta.kn.model;

import lombok.Data;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotEmpty;

@Data
public class AddPlayerRequest {

  // 姓
  @NotEmpty(message = "「姓」は必須項目です")
  @Size(min = 0, max = 255, message = "「姓」は255文字以下でなければなりません")
  private String lastName;

  // 名
  @NotEmpty(message = "「名」は必須項目です")
  @Size(min = 0, max = 255, message = "「名」は255文字以下でなければなりません")
  private String firstName;

  // 姓ふりがな
  @NotEmpty(message = "「姓ふりがな」は必須項目です")
  @Size(min = 0, max = 255, message = "「姓ふりがな」は255文字以下でなければなりません")
  private String lastNameKana;

  // 名ふりがな
  @NotEmpty(message = "「名ふりがな」は必須項目です")
  @Size(min = 0, max = 255, message = "「名ふりがな」は255文字以下でなければなりません")
  private String firstNameKana;

  // 郵便番号
  @NotEmpty(message = "「郵便番号」は必須項目です")
  @Size(min = 7, max = 7, message = "「郵便番号」は7文字でなければなりません")
  @Pattern(regexp = "\\d{7}", message = "「郵便番号」は7桁の数字である必要があります")
  private String postalCode;

  // 住所
  @NotEmpty(message = "「住所」は必須項目です")
  @Size(min = 0, max = 255, message = "「住所」は255文字以下でなければなりません")
  private String address;

  // 生年月日
  @NotEmpty(message = "「生年月日」は必須項目です")
  private String birthday;

  // 電話番号
  @NotEmpty(message = "「電話番号」は必須項目です")
  @Size(min = 0, max = 20, message = "「電話番号」は20文字以下でなければなりません")
  private String telephoneNumber;

  // メールアドレス
  private String email;

  // 段
  @NotEmpty(message = "「段」は必須項目です")
  @Size(min = 1, max = 1, message = "「段」は1文字でなければなりません")
  private String rank;

  // 会員種別
  @NotEmpty(message = "「会員種別」は必須項目です")
  @Size(min = 0, max = 4, message = "「会員種別」は4文字以下でなければなりません")
  private String membershipType;

  // 所属会名
  private String associationName;
}
