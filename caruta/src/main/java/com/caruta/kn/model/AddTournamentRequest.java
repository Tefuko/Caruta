package com.caruta.kn.model;

import com.caruta.kn.enums.Grade;
import lombok.Data;
import lombok.NonNull;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class AddTournamentRequest {

    // 大会名
    @NonNull
    private String tournamentName;

    // 主催会
    private String organizingAssociation;

    // 開催都道府県
    private String hostingPrefecture;

    // 級
    private Grade grade;

    // 開催日
    private String eventDate;

    // True:公認, False:非公認
    private Boolean isOfficial;
}
