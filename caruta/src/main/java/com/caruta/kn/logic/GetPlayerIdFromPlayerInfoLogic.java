package com.caruta.kn.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caruta.kn.repository.GetPlayerIdFromPlayerInfoRepository;

@Component
public class GetPlayerIdFromPlayerInfoLogic {
  @Autowired
  GetPlayerIdFromPlayerInfoRepository getPlayerIdFromPlayerInfoRepository;

   /**
   * 選手情報を元に選手IDを取得
   *
   * @param lastName 姓
   * @param firstName 名
   * @param telephoneNumber 電話番号
   * @return 選手存在有無(True: 存在する、False: 存在しない)
   */
  public Integer getPlayerId(String lastName, String firstName, String telephoneNumber) {

    // 選手情報を元に選手IDを取得するRepositoryを呼び出す
    return getPlayerIdFromPlayerInfoRepository.getPlayerId(
        lastName,
        firstName,
        telephoneNumber);
  }
}
