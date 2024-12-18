package com.caruta.kn.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caruta.kn.mapper.GetPlayerIdFromPlayerInfoMapper;

@Repository
public class GetPlayerIdFromPlayerInfoRepository {

  @Autowired
  GetPlayerIdFromPlayerInfoMapper getPlayerIdFromPlayerInfoMapper;

  /**
   * 選手情報を元に選手IDを取得
   *
   * @param lastName 姓
   * @param firstName 名
   * @param telephoneNumber 電話番号
   * @return playerId 選手ID
   */
  public Integer getPlayerId(String lastName, String firstName, String telephoneNumber) {

    // 選手情報を条件に選手IDをSELECTするmapperを呼び出す
    return getPlayerIdFromPlayerInfoMapper.getPlayerId(
        lastName,
        firstName,
        telephoneNumber);
  }
}
