package com.caruta.kn.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caruta.kn.mapper.AddAssociationMapper;
import com.caruta.kn.model.AddAssociationRequest;
@Repository
public class AddAssociationRepository {

  @Autowired
  AddAssociationMapper addAssociationMapper;

  /**
   * 選手情報をDBに登録
   *
   * @param associationInfo 会情報
   * @param presidentPlayerId 会長選手ID
   * @param vicePresidentPlayerId 副会長選手ID
   */
  public void addAssociation(AddAssociationRequest associationInfo, Integer presidentPlayerId, Integer vicePresidentPlayerId) {

    // 選手情報をDBに登録
    addAssociationMapper.addAssociation(
        associationInfo.getAssociationName(),
        associationInfo.getAffiliatedBranchName(),
        associationInfo.getLocatedPrefecture(),
        presidentPlayerId,
        vicePresidentPlayerId,
        associationInfo.getAssociationEmail());
  }
}
