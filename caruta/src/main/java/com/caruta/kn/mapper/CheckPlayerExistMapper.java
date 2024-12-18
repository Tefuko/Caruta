package com.caruta.kn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CheckPlayerExistMapper {

  // リクエストが来た選手がDB内に存在するかを確認するメソッド
  Integer isExistPlayer(
    @Param("lastName") String lastName,
    @Param("firstName") String firstName,
    @Param("telephoneNumber") String telephoneNumber
  );

}
