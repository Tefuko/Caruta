package com.caruta.kn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DeletePlayerMapper {

  // 指定した選手IDが存在するかを確認するメソッド
  Integer isExistPlayer(@Param("playerId") Integer playerId);

  void deletePlayer(
      @Param("playerId") Integer playerId
  );

}
