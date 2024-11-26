package com.caruta.kn.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.caruta.kn.enums.MessageType;
import com.caruta.kn.exception.ApplicationException;
import com.caruta.kn.model.Message;
import com.caruta.kn.repository.GetAssociationIdFromNameRepository;

@Component
public class GetAssociationIdFromNameLogic {
  @Autowired
  GetAssociationIdFromNameRepository getAssociationIdFromNameRepository;

    /**
   * 所属会名を元に所属会IDを取得
   *
   * @param associationName 所属会名
   * @return associationId 所属会ID
   * @throws ApplicationException 所属会名が会テーブルに存在しない場合
   */
  public Integer getAssociationId(String associationName) throws ApplicationException {

    // 所属会名を元に所属会IDを取得するRepositoryを呼び出す
    Integer associationId = getAssociationIdFromNameRepository.getAssociationId(associationName);

    // 所属会名が会テーブルに存在しない場合エラースロー
    if (associationId == null) {
      throw new ApplicationException(new Message(MessageType.WARNING, "W_0001"));
    }

    return associationId;
  }
}
