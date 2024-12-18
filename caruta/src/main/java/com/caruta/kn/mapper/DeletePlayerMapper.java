package com.caruta.kn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DeletePlayerMapper {

  void deletePlayer(
    @Param("lastName") String lastName,
    @Param("firstName") String firstName,
    @Param("telephoneNumber") String telephoneNumber);

}
