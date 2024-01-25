package com.caruta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caruta.kn.enums.MessageType;
import com.caruta.kn.exception.ApplicationException;
import com.caruta.kn.model.AddPlayerRequest;
import com.caruta.kn.model.Message;
import com.caruta.kn.model.Response;
import com.caruta.kn.service.AddPlayerService;

@RestController
@RequestMapping("/caruta")
@CrossOrigin(origins = "http://localhost:3000")
public class CarutaController {

  @Autowired
  AddPlayerService addPlayerService;

  @PostMapping(value = "/addPlayer", consumes = "application/json")
  public Response<Void> addPlayer(@RequestBody AddPlayerRequest request) {

    Response<Void> response = new Response<>();

    try {
      // 所属会名を元に所属会IDを取得
      Integer affiliationId = addPlayerService.getAffiliationId(request.getAffiliationName());

      // 選手情報をDBに登録
      addPlayerService.addPlayer(request, affiliationId);

    } catch(ApplicationException e) {

      e.getMessages().forEach(message -> {
        response.addMessage(message);
      });
      return response;

    } catch(Throwable e) {

      String message = e.getMessage();
      response.addMessage(new Message(MessageType.DANGER, "E_0001", message));
      return response;
    }

    String playerName = request.getLastName() + request.getFirstName();
    response.addMessage(new Message(MessageType.SUCCESS, "S_0001", playerName));
    return response;
  }
}
