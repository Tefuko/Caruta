package com.caruta.kn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caruta.kn.enums.MessageType;
import com.caruta.kn.exception.ApplicationException;
import com.caruta.kn.model.AddAssociationRequest;
import com.caruta.kn.model.Message;
import com.caruta.kn.repository.AddAssociationRepository;

@Service
public class AddAssociationService {

  @Autowired
  AddAssociationRepository addAssociationRepository;

  /**
   * 会情報をDBに登録
   *
   * @param associationInfo 会情報
   * @param presidentPlayerId 会長選手ID
   * @param vicePresidentPlayerId 副会長選手ID
   */
  public void addAssociation(AddAssociationRequest associationInfo, Integer presidentPlayerId, Integer vicePresidentPlayerId) {

    // 会情報をDBに登録
    addAssociationRepository.addAssociation(associationInfo, presidentPlayerId, vicePresidentPlayerId);

  }
}
