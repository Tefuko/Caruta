package com.caruta.kn.exception;

import java.util.ArrayList;
import java.util.List;

import com.caruta.kn.model.Message;

import lombok.Getter;

@Getter
public class ApplicationException extends RuntimeException {

  private List<Message> messages = new ArrayList<Message>();

  /**
   * コンストラクタ
   *
   * @param message メッセージ
   */
  public ApplicationException(Message message) {
    super(message.toString());
    this.messages.add(message);
  }

  /**
   * コンストラクタ
   *
   * @param messageList メッセージリスト
   */
  public ApplicationException(List<Message> messageList) {
    super(messageList.toString());
    this.messages = messageList;
  }
}
