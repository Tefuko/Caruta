package com.caruta.kn.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caruta.kn.repository.CheckPlayerExistRepository;

@Component
public class CheckPlayerExistLogic {
  @Autowired
  CheckPlayerExistRepository checkPlayerExistRepository;

   /**
   * 選手IDを元に選手存在有無を取得
   *
   * @param lastName 姓
   * @param firstName 名
   * @param telephoneNumber 電話番号
   * @return 選手存在有無(True: 存在する、False: 存在しない)
   */
  public Boolean isExistPlayer(String lastName, String firstName, String telephoneNumber) {

    // 選手情報を元に選手存在有無を取得するRepositoryを呼び出す
    Boolean isExistPlayer = checkPlayerExistRepository.isExistPlayer(lastName, firstName, telephoneNumber);

    return isExistPlayer;
  }
}
