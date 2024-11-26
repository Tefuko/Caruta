package com.caruta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.validation.BindingResult;
import jakarta.validation.Valid;

import com.caruta.kn.enums.MessageType;
import com.caruta.kn.exception.ApplicationException;
import com.caruta.kn.model.Message;
import com.caruta.kn.model.AddPlayerRequest;
// import com.caruta.kn.service.AddAssociationRequest;
// import com.caruta.kn.model.AddTournamentRequest;
import com.caruta.kn.model.DeletePlayerRequest;
import com.caruta.kn.model.Response;
import com.caruta.kn.service.AddPlayerService;
// import com.caruta.kn.service.AddAssociationService;
// import com.caruta.kn.service.AddTournamentService;
import com.caruta.kn.service.DeletePlayerService;
import com.caruta.kn.logic.NumberConverterLogic;
import com.caruta.kn.logic.GetAssociationIdFromNameLogic;

@RestController
@RequestMapping("/caruta")
@CrossOrigin(origins = "http://localhost:3000")
@Validated
// @ControllerAdvice
public class CarutaController {

  @Autowired
  AddPlayerService addPlayerService;
  // @Autowired
  // AddPlayerService addAssociationService;
  // @Autowired
  // AddTournamentService addTournamentService;
  @Autowired
  DeletePlayerService deletePlayerService;
  @Autowired
  NumberConverterLogic numberConverterLogic;
  @Autowired
  GetAssociationIdFromNameLogic getAssociationIdFromNameLogic;

  @PostMapping(value = "/addPlayer", consumes = "application/json")
  // @ExceptionHandler(MethodArgumentNotValidException.class)
  public Response<Void> addPlayer(@Valid @RequestBody AddPlayerRequest request, BindingResult bindingResult) {

    Response<Void> response = new Response<>();

    // バリデーションエラーがある場合は、エラーメッセージをレスポンスに追加
    if (bindingResult.hasErrors()) {
      StringBuilder errorMessages = new StringBuilder();
      bindingResult.getFieldErrors().forEach(error -> {
          String field = error.getField();
          String errorMessage = error.getDefaultMessage();
          errorMessages.append(field).append(": ").append(errorMessage).append(", ");
      });
      String message = errorMessages.length() > 0 ? errorMessages.substring(0, errorMessages.length() - 2) : "";
      response.addMessage(new Message(MessageType.DANGER, "E_0001", message));
      return response;
    }

    try {
      // 電話番号を半角数字のみに変換
      String telephoneNumber = numberConverterLogic.convertToHalfWidthNumber(request.getTelephoneNumber());

      // 選手情報を元に既にその選手がDBに登録されているかを判定
      addPlayerService.isExistPlayer(request.getLastName(), request.getFirstName(), telephoneNumber);

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
      // 選手IDを元に選手の存在有無を確認
      deletePlayerService.isExistPlayer(request.getPlayerId());

      // 選手情報を削除（論理削除）
      deletePlayerService.deletePlayer(request);

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

    response.addMessage(new Message(MessageType.SUCCESS, "S_0003", String.valueOf(request.getPlayerId())));
    return response;
  }

  // @PostMapping(value = "/addAssociation", consumes = "application/json")
  // public Response<Void> AddAssociation(@RequestBody AddAssociationRequest request) {

  //   Response<Void> response = new Response<>();

  //   try {
  //     // 会長選手IDを取得(仮で1に設定)
  //     String presidentPlayerId = 1;

  //     // 副会長選手IDを取得(仮で1に設定)
  //     String vicePresidentPlayerId = 1;

  //     // 所属会名を元に所属会IDを取得
  //     Integer affiliationId = addPlayerService.getAffiliationId(request.getAffiliationName());

  //     // 選手情報をDBに登録
  //     addPlayerService.addPlayer(request, affiliationId, telephoneNumber);

  //   } catch(ApplicationException e) {

  //     e.getMessages().forEach(message -> {
  //       response.addMessage(message);
  //     });
  //     return response;

  //   } catch(Throwable e) {

  //     String message = e.getMessage();
  //     response.addMessage(new Message(MessageType.DANGER, "E_0001", message));
  //     return response;
  //   }

  //   String playerName = request.getLastName() + request.getFirstName();
  //   response.addMessage(new Message(MessageType.SUCCESS, "S_0001", playerName));
  //   return response;
  // }

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
