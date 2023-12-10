package com.caruta.kn.mapper;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.caruta.kn.entity.TestTable;
import com.caruta.kn.model.Demo2Response;

@Mapper
public interface DemoMapper {

  void demo(
    @Param("arg") String arg
  );

  Demo2Response[] demo2();

  void demo3(
    @Param("name") String name,
    @Param("address") String address,
    @Param("gender") String gender,
    @Param("height") BigDecimal height
  );

  TestTable[] demo4();
}
