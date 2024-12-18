package com.caruta.kn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface GetPlayerIdFromPlayerInfoMapper {

  // 選手情報から選手IDを取得するメソッド
  Integer getPlayerId(
    @Param("lastName") String lastName,
    @Param("firstName") String firstName,
    @Param("telephoneNumber") String telephoneNumber);
}
