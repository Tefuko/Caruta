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
   * 所属会名を元に所属会IDを取得
   *
   * @param affiliationName 所属会名
   * @return affiliationId 所属会ID
   * @throws ApplicationException 所属会名が会テーブルに存在しない場合
   */
  public Integer getAffiliationId(String affiliationName) throws ApplicationException {

    // 所属会名を元に所属会IDを取得するRepositoryを呼び出す
    Integer affiliationId = addPlayerRepository.getAffiliationId(affiliationName);

    // 所属会名が会テーブルに存在しない場合エラースロー
    if (affiliationId == null) {
      throw new ApplicationException(new Message(MessageType.WARNING, "W_0001"));
    }

    return affiliationId;
  }

  /**
   * 選手情報をDBに登録
   *
   * @param playerInfo    選手情報
   * @param affiliationId 所属会ID
   * @throws ApplicationException 日付型への変換に失敗した場合
   */
  public void addPlayer(AddPlayerRequest playerInfo, Integer affiliationId) throws ApplicationException {

    // 生年月日をDate型に変換
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    try {

      Date birthday = dateFormat.parse(playerInfo.getBirthday());

      // 選手情報をDBに登録
      addPlayerRepository.addPlayer(playerInfo, affiliationId, birthday);

    } catch (ParseException e) {
      throw new ApplicationException(new Message(MessageType.WARNING, "W_0002"));
    }
  }
}
