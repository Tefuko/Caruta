package com.caruta.kn.model;

import java.text.MessageFormat;
import java.util.ResourceBundle;

import org.springframework.context.NoSuchMessageException;

import com.caruta.kn.enums.MessageType;

import lombok.Data;

@Data
public class Message {

  private String code;
  private MessageType type;
  private String message;

  /**
   * コンストラクタ
   *
   * @param type        メッセージ種別
   * @param messageCode メッセージコード
   */
  public Message(MessageType type, String messageCode) {
    this.code = messageCode;
    this.message = getMessage(messageCode, (String) null);
    this.type = type;
  }

  /**
   * コンストラクタ
   *
   * @param type        メッセージ種別
   * @param messageCode メッセージコード
   * @param messageArgs メッセージ引数
   */
  public Message(MessageType type, String messageCode, String... messageArgs) {
    this.code = messageCode;
    this.message = getMessage(messageCode, messageArgs);
    this.type = type;
  }

  /**
   * メッセージコードとオプションのメッセージ引数を使用してメッセージを取得します。
   *
   * @param messageCode メッセージコード
   * @param messageArgs メッセージ引数
   * @return 取得したメッセージ（見つからない場合はnull）
   */
  private static String getMessage(String messageCode, String... messageArgs) {

    // message.propertiesから読み込み
    ResourceBundle messages = ResourceBundle.getBundle("messages");
    String message = messages.getString(messageCode);

    try {
      if (messageArgs != null && messageArgs.length > 0)

        message = MessageFormat.format(message, (Object[])messageArgs);

    } catch (NoSuchMessageException e) {

      return null;
    }

    return message;
  }
}
