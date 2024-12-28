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

@Service
public class AddPlayerService {

  @Autowired
  AddPlayerRepository addPlayerRepository;

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
