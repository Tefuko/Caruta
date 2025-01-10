package com.caruta.kn.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caruta.kn.enums.MessageType;
import com.caruta.kn.exception.ApplicationException;
import com.caruta.kn.model.Message;

import com.caruta.kn.repository.GetPlayerIdFromPlayerInfoRepository;
import com.caruta.kn.logic.CheckPlayerExistLogic;

@Component
public class GetPlayerIdFromPlayerInfoLogic {
  @Autowired
  GetPlayerIdFromPlayerInfoRepository getPlayerIdFromPlayerInfoRepository;
  @Autowired
  CheckPlayerExistLogic checkPlayerExistLogic;

   /**
   * 選手情報を元に選手IDを取得
   *
   * @param lastName 姓
   * @param firstName 名
   * @param telephoneNumber 電話番号
   * @return 選手ID
   */
  public Integer getPlayerId(String lastName, String firstName, String telephoneNumber) {

    // 選手情報を元に選手存在有無を取得し、存在しない場合にエラーメッセージを投げる
    if(!checkPlayerExistLogic.isExistPlayer(lastName, firstName, telephoneNumber)) {
      throw new ApplicationException(new Message(MessageType.WARNING, "W_0004"));
    }

    // 選手情報を元に選手IDを取得するRepositoryを呼び出す
    return getPlayerIdFromPlayerInfoRepository.getPlayerId(
        lastName,
        firstName,
        telephoneNumber);
  }
}
