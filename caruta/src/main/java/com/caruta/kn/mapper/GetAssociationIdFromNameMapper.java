package com.caruta.kn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GetAssociationIdFromNameMapper {

  // 会名から会IDを取得するメソッド
  Integer getAssociationId(
      @Param("associationName") String associationName);

}
