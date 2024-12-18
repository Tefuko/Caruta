package com.caruta.kn.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caruta.kn.mapper.CheckPlayerExistMapper;
@Repository
public class CheckPlayerExistRepository {

  @Autowired
  CheckPlayerExistMapper checkPlayerExistMapper;

  /**
   * 選手情報を元に、その選手がDBに存在するかどうかを取得
   *
   * @param lastName 姓
   * @param firstName 名
   * @param telephoneNumber 電話番号
   * @return 選手存在有無(True: 存在する、False: 存在しない)
   */
  public Boolean isExistPlayer(String lastName, String firstName, String telephoneNumber) {

    // 選手情報(姓、名、電話番号)に一致する選手情報を持つ行数をcountするmapperを呼び出す
    Integer countPlayerId = checkPlayerExistMapper.isExistPlayer(
      lastName,
      firstName,
      telephoneNumber);
    return countPlayerId > 0;
  }
}
