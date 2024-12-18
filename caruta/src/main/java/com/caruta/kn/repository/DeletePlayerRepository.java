package com.caruta.kn.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caruta.kn.mapper.DeletePlayerMapper;
import com.caruta.kn.model.DeletePlayerRequest;
@Repository
public class DeletePlayerRepository {

  @Autowired
  DeletePlayerMapper deletePlayerMapper;

  /**
   * 選手情報をDBから削除（論理削除）
   *
   * @param lastName 姓
   * @param firstName 名
   * @param telephoneNumber 電話番号
   */
  public void deletePlayer(String lastName, String firstName, String telephoneNumber) {

    // 該当選手IDの選手データをDBから削除
    deletePlayerMapper.deletePlayer(
      lastName,
      firstName,
      telephoneNumber);
  }
}
