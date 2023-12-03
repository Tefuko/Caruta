package com.caruta.kn.entity;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TestTable {

  private Integer id;
  private String name;
  private String address;
  private String gender;
  private BigDecimal height;
  private Boolean deleteFlg;
}
