package com.caruta.kn.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caruta.kn.mapper.GetAssociationIdFromNameMapper;

@Repository
public class GetAssociationIdFromNameRepository {

  @Autowired
  GetAssociationIdFromNameMapper getAssociationIdFromNameMapper;

  /**
   * 所属会名を元に所属会IDを取得
   *
   * @param associationName 所属会名
   * @return associationId 所属会ID
   */
  public Integer getAssociationId(String associationName) {

    // 所属会名を条件に所属会IDをSELECTするmapperを呼び出す
    return getAssociationIdFromNameMapper.getAssociationId(associationName);
  }
}
