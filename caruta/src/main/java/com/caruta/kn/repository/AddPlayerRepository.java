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

  // /**
  //  * 選手情報を元に、その選手がDBに存在するかどうかを取得
  //  *
  //  * @param lastName 姓
  //  * @param firstName 名
  //  * @param telephoneNumber 電話番号
  //  * @return 選手存在有無(True: 存在する、False: 存在しない)
  //  */
  // public Boolean isExistPlayer(String lastName, String firstName, String telephoneNumber) {

  //   // 選手情報(姓、名、電話番号)に一致する選手情報を持つ行数をcountするmapperを呼び出す
  //   Integer countPlayerId = addPlayerMapper.isExistPlayer(
  //     lastName,
  //     firstName,
  //     telephoneNumber);
  //   return countPlayerId > 0;
  // }

  /**
   * 選手情報をDBに登録
   *
   * @param playerInfo 選手情報
   * @param affiliationId 所属会ID
   * @param birthday 生年月日
   * @param telephoneNumber 電話番号
   */
  public void addPlayer(AddPlayerRequest playerInfo, Integer associationId, Date birthday, String telephoneNumber) {

    // 選手情報をDBに登録
    addPlayerMapper.addPlayer(
      playerInfo.getLastName(),
      playerInfo.getFirstName(),
      playerInfo.getLastNameKana(),
      playerInfo.getFirstNameKana(),
      playerInfo.getPostalCode(),
      playerInfo.getAddress(),
      birthday,
      telephoneNumber,
      playerInfo.getEmail(),
      playerInfo.getRank(),
      playerInfo.getMembershipType(),
      associationId);
  }
}
