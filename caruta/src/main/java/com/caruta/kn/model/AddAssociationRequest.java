package com.caruta.kn.model;

import lombok.Data;

@Data
public class AddAssociationRequest {

  // 会名
  private String associationName;

  // 所属支部名
  private String affiliatedBranchName;

  // 都道府県
  private String locatedPrefecture;

  // 会長の姓
  private String presidentLastName;

  // 会長の名
  private String presidentFirstName;

  // 会長の電話番号
  private String presidentTelephoneNumber;

  // 副会長の姓
  private String vicePresidentLastName;

  // 副会長の名
  private String vicePresidentFirstName;

  // 副会長の電話番号
  private String vicePresidentTelephoneNumber;

  // 会メールアドレス
  private String associationEmail;
}
