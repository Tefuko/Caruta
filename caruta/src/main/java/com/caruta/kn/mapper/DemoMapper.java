package com.caruta.kn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DemoMapper {

  void demo(
    @Param("arg") String arg
  );
}
