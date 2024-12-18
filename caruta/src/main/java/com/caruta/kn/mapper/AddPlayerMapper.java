package com.caruta.kn.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddPlayerMapper {

//   Integer getAffiliationId(
//       @Param("affiliationName") String affiliationName);

  // // 登録リクエストが来た選手がDB内に存在するかを確認するメソッド
  // Integer isExistPlayer(
  //   @Param("lastName") String lastName,
  //   @Param("firstName") String firstName,
  //   @Param("telephoneNumber") String telephoneNumber
  // );

  void addPlayer(
    @Param("lastName") String lastName,
    @Param("firstName") String firstName,
    @Param("lastNameKana") String lastNameKana,
    @Param("firstNameKana") String firstNameKana,
    @Param("postalCode") String postalCode,
    @Param("address") String address,
    @Param("birthday") Date birthday,
    @Param("telephoneNumber") String telephoneNumber,
    @Param("email") String email,
    @Param("rank") String rank,
    @Param("membershipType") String membershipType,
    @Param("associationId") Integer associationId
  );

}
