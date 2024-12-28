package com.caruta.kn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caruta.kn.enums.MessageType;
import com.caruta.kn.exception.ApplicationException;
import com.caruta.kn.model.DeletePlayerRequest;
import com.caruta.kn.model.Message;
import com.caruta.kn.repository.DeletePlayerRepository;

@Service
public class DeletePlayerService {

  @Autowired
  DeletePlayerRepository deletePlayerRepository;

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
