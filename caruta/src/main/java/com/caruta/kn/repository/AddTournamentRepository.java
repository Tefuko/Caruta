package com.caruta.kn.repository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.caruta.kn.mapper.AddTournamentMapper;
import com.caruta.kn.model.AddTournamentRequest;

@Repository
public class AddTournamentRepository {

    @Autowired
    AddTournamentMapper addTournamentMapper;

    public void addTournament(AddTournamentRequest request, Date eventDate) {
        addTournamentMapper.addTournament(
            request.getTournamentName(),
            request.getOrganizingAssociation(),
            request.getHostingPrefecture(),
            request.getGrade().toString(),
            eventDate,
            request.getIsOfficial()
        );
    }
}
