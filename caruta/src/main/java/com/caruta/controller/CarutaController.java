package com.caruta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

import com.caruta.kn.enums.MessageType;
import com.caruta.kn.exception.ApplicationException;
import com.caruta.kn.model.Message;
import com.caruta.kn.model.AddPlayerRequest;
import com.caruta.kn.model.AddAssociationRequest;
// import com.caruta.kn.model.AddTournamentRequest;
import com.caruta.kn.model.DeletePlayerRequest;
import com.caruta.kn.model.Response;
import com.caruta.kn.service.AddPlayerService;
import com.caruta.kn.service.AddAssociationService;
// import com.caruta.kn.service.AddTournamentService;
import com.caruta.kn.service.DeletePlayerService;
import com.caruta.kn.logic.NumberConverterLogic;
import com.caruta.kn.logic.GetAssociationIdFromNameLogic;
import com.caruta.kn.logic.GetPlayerIdFromPlayerInfoLogic;

@RestController
@RequestMapping("/caruta")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
// @ControllerAdvice
public class CarutaController {

  @Autowired
  AddPlayerService addPlayerService;
  @Autowired
  AddAssociationService addAssociationService;
  // @Autowired
  // AddTournamentService addTournamentService;
  @Autowired
  DeletePlayerService deletePlayerService;
  @Autowired
  NumberConverterLogic numberConverterLogic;
  @Autowired
  GetAssociationIdFromNameLogic getAssociationIdFromNameLogic;
  @Autowired
  GetPlayerIdFromPlayerInfoLogic getPlayerIdFromPlayerInfoLogic;

  @PostMapping(value = "/addPlayer", consumes = "application/json")
  // @ExceptionHandler(MethodArgumentNotValidException.class)
  public Response<Void> addPlayer(@Valid @RequestBody AddPlayerRequest request, BindingResult bindingResult) {

    Response<Void> response = new Response<>();

    try {
      // 電話番号を半角数字のみに変換
      String telephoneNumber = numberConverterLogic.convertToHalfWidthNumber(request.getTelephoneNumber());

      // // 選手情報を元に既にその選手がDBに登録されているかを判定
      // addPlayerService.isExistPlayer(request.getLastName(), request.getFirstName(), telephoneNumber);

      // 選手情報を元に既にその選手がDBに登録されているかを判定
      // Boolean isExistPlayer = addPlayerService.isExistPlayer(request.getLastName(), request.getFirstName(), telephoneNumber);
      if (addPlayerService.isExistPlayer(request.getLastName(), request.getFirstName(), telephoneNumber)) {
        response.addMessage(new Message(MessageType.WARNING, "W_0005"));
        return response;
      }

      // 所属会名を元に所属会IDを取得
      Integer associationId = getAssociationIdFromNameLogic.getAssociationId(request.getAssociationName());

      // 選手情報をDBに登録
      addPlayerService.addPlayer(request, associationId, telephoneNumber);

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

  @PostMapping(value = "/deletePlayer", consumes = "application/json")
  public Response<Void> deletePlayer(@RequestBody DeletePlayerRequest request) {

    Response<Void> response = new Response<>();

    try {
      // 電話番号を半角数字のみに変換
      String telephoneNumber = numberConverterLogic.convertToHalfWidthNumber(request.getTelephoneNumber());

      // 選手情報を元に既にその選手がDBに登録されているかを判定
      // deletePlayerService.isExistPlayer(request.getLastName(), request.getFirstName(), telephoneNumber);
      if (!deletePlayerService.isExistPlayer(request.getLastName(), request.getFirstName(), telephoneNumber)) {
        response.addMessage(new Message(MessageType.WARNING, "W_0004"));
        return response;
      }

      // // 選手情報を元に選手IDを取得
      // Integer playerId = getPlayerIdFromPlayerInfoLogic.getPlayerId(request.getLastName(), request.getFirstName(), telephoneNumber);

      // 選手情報を削除（論理削除）
      deletePlayerService.deletePlayer(request.getLastName(), request.getFirstName(), telephoneNumber);

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
    response.addMessage(new Message(MessageType.SUCCESS, "S_0003", String.valueOf(playerName)));
    return response;
  }

  @PostMapping(value = "/addAssociation", consumes = "application/json")
  public Response<Void> AddAssociation(@RequestBody AddAssociationRequest request) {

    Response<Void> response = new Response<>();

    try {
      // 会長、副会長ともに電話番号を半角数字のみに変換
      String presidentTelephoneNumber = numberConverterLogic.convertToHalfWidthNumber(request.getPresidentTelephoneNumber());
      String vicePresidentTelephoneNumber = numberConverterLogic.convertToHalfWidthNumber(request.getVicePresidentTelephoneNumber());

      // 会長選手IDを取得
      Integer presidentPlayerId = getPlayerIdFromPlayerInfoLogic.getPlayerId(request.getPresidentLastName(), request.getPresidentFirstName(), presidentTelephoneNumber);

      // 副会長選手IDを取得
      Integer vicePresidentPlayerId = getPlayerIdFromPlayerInfoLogic.getPlayerId(request.getVicePresidentLastName(), request.getVicePresidentFirstName(), vicePresidentTelephoneNumber);

      // 会情報をDBに登録
      addAssociationService.addAssociation(request, presidentPlayerId, vicePresidentPlayerId);

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

    response.addMessage(new Message(MessageType.SUCCESS, "S_0004", request.getAssociationName()));
    return response;
  }

  // @PostMapping(value = "/addTournament", consumes = "application/json")
  // public Response<Void> addTournament(@RequestBody AddTournamentRequest request) {

  //   Response<Void> response = new Response<>();

  //   try {
  //     // 主催会名を元に所属会IDを取得
  //     Integer affiliationId = addPlayerService.getAffiliationId(request.getOrganizingAssociation());

  //     // 大会情報をDBに登録
  //     addTournamentService.addTournament(request);

  //   } catch(ApplicationException e) {

  //     e.getMessages().forEach(message -> {
  //       response.addMessage(message);
  //     });
  //     return response;

  //   } catch (Throwable e) {

  //     String message = e.getMessage();
  //     response.addMessage(new Message(MessageType.DANGER, "E_0001", message));
  //     return response;
  //   }

  //   String tournamentName = request.getTournamentName();
  //   response.addMessage(new Message(MessageType.SUCCESS, "S_0002", tournamentName));
  //   return response;
  // }
}
