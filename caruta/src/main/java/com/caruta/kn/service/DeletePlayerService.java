package com.caruta.kn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caruta.kn.enums.MessageType;
import com.caruta.kn.exception.ApplicationException;
import com.caruta.kn.model.DeletePlayerRequest;
import com.caruta.kn.model.Message;
import com.caruta.kn.repository.DeletePlayerRepository;

import com.caruta.kn.logic.CheckPlayerExistLogic;

@Service
public class DeletePlayerService {

  @Autowired
  DeletePlayerRepository deletePlayerRepository;
  @Autowired
  CheckPlayerExistLogic checkPlayerExistLogic;

  /**
   * 選手IDを元に選手存在有無を取得
   *
   * @param playerId 選手ID
   * @throws ApplicationException 所属会名が会テーブルに存在しない場合
   */
  // public void isExistPlayer(String lastName, String firstName, String telephoneNumber) throws ApplicationException {
  public Boolean isExistPlayer(String lastName, String firstName, String telephoneNumber) {

    // 選手IDを元に選手存在有無を取得するRepositoryを呼び出す
    // Boolean isExistPlayer = checkPlayerExistLogic.isExistPlayer(lastName, firstName, telephoneNumber);

    return checkPlayerExistLogic.isExistPlayer(lastName, firstName, telephoneNumber);

    // // 所属会名が会テーブルに存在しない場合エラースロー
    // if (!isExistPlayer) {
    //   throw new ApplicationException(new Message(MessageType.WARNING, "W_0004"));
    // }
  }

  /**
   * 選手情報をDBから削除
   *
   * @param lastName 姓
   * @param firstName 名
   * @param telephoneNumber 電話番号
   */
  public void deletePlayer(String lastName, String firstName, String telephoneNumber) {

    // 選手情報をDBから削除（論理削除）
    deletePlayerRepository.deletePlayer(
      lastName,
      firstName,
      telephoneNumber);
  }
}
