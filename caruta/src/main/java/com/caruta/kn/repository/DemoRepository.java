package com.caruta.kn.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caruta.kn.mapper.DemoMapper;
import com.caruta.kn.model.Demo2Response;

@Repository
public class DemoRepository {

  @Autowired
  private DemoMapper demoMapper;

  public void demo(String arg) {
    System.out.println("repository");
    System.out.println(arg);
  };

  public Demo2Response[] demo2() {
    return demoMapper.demo2();
  };
}
