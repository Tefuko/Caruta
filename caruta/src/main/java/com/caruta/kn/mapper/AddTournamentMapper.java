package com.caruta.kn.mapper;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AddTournamentMapper {

    void addTournament(
        @Param("tournamentName") String tournamentName,
        @Param("organizingAssociation") String organizingAssociation,
        @Param("hostingPrefecture") String hostingPrefecture,
        @Param("grade") String grade,
        @Param("eventDate") Date eventDate,
        @Param("officialStatus") boolean isOfficial
    );
}