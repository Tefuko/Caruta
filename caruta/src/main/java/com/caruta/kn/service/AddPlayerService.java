package com.caruta.kn.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caruta.kn.enums.MessageType;
import com.caruta.kn.exception.ApplicationException;
import com.caruta.kn.model.AddPlayerRequest;
import com.caruta.kn.model.Message;
import com.caruta.kn.repository.AddPlayerRepository;

import com.caruta.kn.logic.CheckPlayerExistLogic;

@Service
public class AddPlayerService {

  @Autowired
  AddPlayerRepository addPlayerRepository;
  @Autowired
  CheckPlayerExistLogic checkPlayerExistLogic;

  /**
   * 選手IDを元に選手存在有無を取得
   *
   * @param lastName 姓
   * @param firstName 名
   * @param telephoneNumber 電話番号
   * @return 選手存在有無(True: 存在する、False: 存在しない)
   */
  // public void isExistPlayer(String lastName, String firstName, String telephoneNumber) {
  public Boolean isExistPlayer(String lastName, String firstName, String telephoneNumber) {

    // // 選手情報を元に選手存在有無を取得するRepositoryを呼び出す
    // Boolean isExistPlayer = checkPlayerExistLogic.isExistPlayer(lastName, firstName, telephoneNumber);

    // return isExistPlayer;

    // 選手情報を元に選手存在有無を取得するRepositoryを呼び出す
    return checkPlayerExistLogic.isExistPlayer(lastName, firstName, telephoneNumber);

    // // 選手が既にDB内に存在する場合エラースロー
    // if (isExistPlayer) {
    //   throw new ApplicationException(new Message(MessageType.WARNING, "W_0005"));
    // }
  }

  /**
   * 選手情報をDBに登録
   *
   * @param playerInfo    選手情報
   * @param associationId 所属会ID
   * @throws ApplicationException 日付型への変換に失敗した場合
   */
  public void addPlayer(AddPlayerRequest playerInfo, Integer associationId, String telephoneNumber) throws ApplicationException {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    try {

      // 生年月日をDate型に変換
      Date birthday = dateFormat.parse(playerInfo.getBirthday());

      // 選手情報をDBに登録
      addPlayerRepository.addPlayer(playerInfo, associationId, birthday, telephoneNumber);

    } catch (ParseException e) {
      throw new ApplicationException(new Message(MessageType.WARNING, "W_0002"));
    }
  }
}
