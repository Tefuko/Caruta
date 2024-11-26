package com.caruta.kn.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.caruta.kn.mapper.DeletePlayerMapper;
import com.caruta.kn.model.DeletePlayerRequest;
@Repository
public class DeletePlayerRepository {

  @Autowired
  DeletePlayerMapper deletePlayerMapper;

  /**
   * 選手IDを元に、その選手IDの選手がDBに存在するかどうかを取得
   *
   * @param playerId 選手ID
   * @return 選手存在有無(True: 存在する、False: 存在しない)
   */
  public Boolean isExistPlayer(Integer playerId) {

    // 選手IDに一致する選手IDを持つ行数をcountするmapperを呼び出す
    Integer countPlayerId = deletePlayerMapper.isExistPlayer(playerId);
    return countPlayerId == 1;
  }

  /**
   * 選手情報をDBから削除（論理削除）
   *
   * @param playerInfo 選手情報
   */
  public void deletePlayer(DeletePlayerRequest playerInfo) {

    // 選手情報をDBに登録
    deletePlayerMapper.deletePlayer(
      playerInfo.getPlayerId()
      );
  }
}
