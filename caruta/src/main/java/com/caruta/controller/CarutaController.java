package com.caruta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caruta.kn.model.AddPlayerRequest;
import com.caruta.kn.service.AddPlayerService;
import com.caruta.kn.utils.ApplicationException;

@RestController
@RequestMapping("/caruta")
@CrossOrigin(origins = "http://localhost:3000")
public class CarutaController {

  @Autowired
  AddPlayerService addPlayerService;

  @PostMapping(value = "/addPlayer", consumes = "application/json")
  public String addPlayer(@RequestBody AddPlayerRequest request) {

    try {
      // 所属会名を元に所属会IDを取得
      Integer affiliationId = addPlayerService.getAffiliationId(request.getAffiliationName());

      // 選手情報をDBに登録
      addPlayerService.addPlayer(request, affiliationId);

    } catch(ApplicationException e) {
      return e.getErrorCode() + ":" + e.getMessage();
    }

    return "登録成功";
  }
}
