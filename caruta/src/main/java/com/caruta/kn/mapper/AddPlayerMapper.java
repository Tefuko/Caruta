package com.caruta.kn.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddPlayerMapper {

  Integer getAffiliationId(
      @Param("affiliationName") String affiliationName);

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
      @Param("affiliationId") Integer affiliationId);

}
