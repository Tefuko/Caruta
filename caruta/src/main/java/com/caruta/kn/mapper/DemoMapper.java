package com.caruta.kn.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.caruta.kn.model.Demo2Response;

@Mapper
public interface DemoMapper {

  void demo(
    @Param("arg") String arg
  );

  Demo2Response[] demo2();
}
