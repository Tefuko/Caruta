package com.caruta.kn.repository;

import org.springframework.stereotype.Repository;

@Repository
public class DemoRepository {

  public void demo(String arg) {
    System.out.println("repository");
    System.out.println(arg);
  };
}
