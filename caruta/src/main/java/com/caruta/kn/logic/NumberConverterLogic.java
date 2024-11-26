package com.caruta.kn.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NumberConverterLogic {

    /**
     * 与えられた文字列から全角数字を半角数字に変換する
     * 
     * @param input 数字のみの羅列（全角・半角混在可）
     * @return 半角数字のみの文字列
     */
    public String convertToHalfWidthNumber(String input) {
        StringBuilder result = new StringBuilder(input.length());
        for (char c : input.toCharArray()) {
            if (c >= '０' && c <= '９') { // 全角数字の場合
                c = (char) (c - '０' + '0'); // 半角数字に変換
            }
            result.append(c);
        }
        return result.toString();
    }
}
