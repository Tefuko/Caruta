package com.caruta.kn.model;

import lombok.Data;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotEmpty;

@Data
public class AddAssociationRequest {

  // 会名
  @NotEmpty(message = "「会名」は必須項目です")
  @Size(min = 0, max = 20, message = "「会名」は20文字以下でなければなりません")
  private String associationName;

  // 所属支部名
  @NotEmpty(message = "「所属支部名」は必須項目です")
  @Size(min = 0, max = 10, message = "「所属支部名」は10文字以下でなければなりません")
  private String affiliatedBranchName;

  // 都道府県
  @NotEmpty(message = "「都道府県」は必須項目です")
  @Size(min = 0, max = 10, message = "「都道府県」は10文字以下でなければなりません")
  private String locatedPrefecture;

  // 会長の姓
  @NotEmpty(message = "「会長の姓」は必須項目です")
  @Size(min = 0, max = 255, message = "「会長の姓」は255文字以下でなければなりません")
  private String presidentLastName;

  // 会長の名
  @NotEmpty(message = "「会長の名」は必須項目です")
  @Size(min = 0, max = 255, message = "「会長の名」は255文字以下でなければなりません")
  private String presidentFirstName;

  // 会長の電話番号
  @NotEmpty(message = "「会長の電話番号」は必須項目です")
  @Size(min = 0, max = 20, message = "「会長の電話番号」は20文字以下でなければなりません")
  private String presidentTelephoneNumber;

  // 副会長の姓
  @NotEmpty(message = "「副会長の姓」は必須項目です")
  @Size(min = 0, max = 255, message = "「副会長の姓」は255文字以下でなければなりません")
  private String vicePresidentLastName;

  // 副会長の名
  @NotEmpty(message = "「副会長の名」は必須項目です")
  @Size(min = 0, max = 255, message = "「副会長の名」は255文字以下でなければなりません")
  private String vicePresidentFirstName;

  // 副会長の電話番号
  @NotEmpty(message = "「副会長の電話番号」は必須項目です")
  @Size(min = 0, max = 20, message = "「副会長の電話番号」は20文字以下でなければなりません")
  private String vicePresidentTelephoneNumber;

  // 会メールアドレス
  @NotEmpty(message = "「会メールアドレス」は必須項目です")
  @Size(min = 0, max = 255, message = "「会メールアドレス」は255文字以下でなければなりません")
  private String associationEmail;
}
