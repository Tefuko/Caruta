// package com.caruta.kn.service;

// import java.text.ParseException;
// import java.text.SimpleDateFormat;
// import java.util.Date;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;

// import com.caruta.kn.enums.MessageType;
// import com.caruta.kn.exception.ApplicationException;
// import com.caruta.kn.model.AddAssociationRequest;
// import com.caruta.kn.model.Message;
// // import com.caruta.kn.repository.AddAssociationRepository;

// @Service
// public class AddPlayerService {

//   @Autowired
//   AddPlayerRepository addPlayerRepository;

//   /**
//    * 所属会名を元に所属会IDを取得
//    *
//    * @param affiliationName 所属会名
//    * @return affiliationId 所属会ID
//    * @throws ApplicationException 所属会名が会テーブルに存在しない場合
//    */
//   public Integer getAffiliationId(String affiliationName) throws ApplicationException {

//     // 所属会名を元に所属会IDを取得するRepositoryを呼び出す
//     Integer affiliationId = addPlayerRepository.getAffiliationId(affiliationName);

//     // 所属会名が会テーブルに存在しない場合エラースロー
//     if (affiliationId == null) {
//       throw new ApplicationException(new Message(MessageType.WARNING, "W_0001"));
//     }

//     return affiliationId;
//   }

//   /**
//    * 選手IDを元に選手存在有無を取得
//    *
//    * @param lastName 姓
//    * @param firstName 名
//    * @param telephoneNumber 電話番号
//    * @return 選手存在有無(True: 存在する、False: 存在しない)
//    */
//   public void isExistPlayer(String lastName, String firstName, String telephoneNumber) {

//     // 選手情報を元に選手存在有無を取得するRepositoryを呼び出す
//     Boolean isExistPlayer = addPlayerRepository.isExistPlayer(lastName, firstName, telephoneNumber);

//     // 選手が既にDB内に存在する場合エラースロー
//     if (isExistPlayer) {
//       throw new ApplicationException(new Message(MessageType.WARNING, "W_0005"));
//     }
//   }

//   /**
//    * 選手情報をDBに登録
//    *
//    * @param playerInfo    選手情報
//    * @param affiliationId 所属会ID
//    * @throws ApplicationException 日付型への変換に失敗した場合
//    */
//   public void addPlayer(AddPlayerRequest playerInfo, Integer affiliationId, String telephoneNumber) throws ApplicationException {

//     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//     try {

//       // 生年月日をDate型に変換
//       Date birthday = dateFormat.parse(playerInfo.getBirthday());

//       // 選手情報をDBに登録
//       addPlayerRepository.addPlayer(playerInfo, affiliationId, birthday, telephoneNumber);

//     } catch (ParseException e) {
//       throw new ApplicationException(new Message(MessageType.WARNING, "W_0002"));
//     }
//   }
// }
