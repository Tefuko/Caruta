package com.caruta.kn.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caruta.kn.mapper.AddPlayerMapper;
import com.caruta.kn.model.AddPlayerRequest;
@Repository
public class AddPlayerRepository {

  @Autowired
  AddPlayerMapper addPlayerMapper;

  /**
   * 所属会名を元に所属会IDを取得
   *
   * @param affiliationName 所属会名
   * @return affiliationId 所属会ID
   */
  public Integer getAffiliationId(String affiliationName) {

    // 所属会名を条件に所属会IDをSELECTするmapperを呼び出す
    // return addPlayerMapper.getAffiliationId(affiliationName);

    // DBにレコード用意するまで仮置き
    return 1;
  }

  /**
   * 選手情報をDBに登録
   *
   * @param playerInfo 選手情報
   * @param affiliationId 所属会ID
   * @param birthday 生年月日
   */
  public void addPlayer(AddPlayerRequest playerInfo, Integer affiliationId, Date birthday) {

    // 選手情報をDBに登録
    addPlayerMapper.addPlayer(
      playerInfo.getLastName(),
      playerInfo.getFirstName(),
      playerInfo.getLastNameKana(),
      playerInfo.getFirstNameKana(),
      playerInfo.getPostalCode(),
      playerInfo.getAddress(),
      birthday,
      playerInfo.getTelephoneNumber(),
      playerInfo.getEmail(),
      playerInfo.getRank(),
      playerInfo.getMembershipType(),
      affiliationId);
  }
}
