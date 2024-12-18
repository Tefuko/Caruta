package com.caruta.kn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddAssociationMapper {

  void addAssociation(
    @Param("associationName") String associationName,
    @Param("affiliatedBranchName") String affiliatedBranchName,
    @Param("locatedPrefecture") String locatedPrefecture,
    @Param("presidentPlayerId") Integer presidentPlayerId,
    @Param("vicePresidentPlayerId") Integer vicePresidentPlayerId,
    @Param("associationEmail") String associationEmail
  );

}
