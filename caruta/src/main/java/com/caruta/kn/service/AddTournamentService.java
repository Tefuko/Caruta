package com.caruta.kn.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.caruta.kn.enums.MessageType;
import com.caruta.kn.exception.ApplicationException;
import com.caruta.kn.model.Message;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.caruta.kn.model.AddTournamentRequest;
import com.caruta.kn.repository.AddTournamentRepository;

@Service
public class AddTournamentService {

    @Autowired
    AddTournamentRepository addTournamentRepository;

    /**
     * 大会情報をDBに登録
     * 
     * @throws ApplicationException 日付型への変換に失敗した場合
     */
    public void addTournament(AddTournamentRequest request) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        try {

            Date eventDate = dateFormat.parse(request.getEventDate());
            Date currentDate = new Date();
            
            // イベントの日付が現在の日付より後かを確認
            if (eventDate.before(currentDate) || DateUtils.isSameDay(eventDate, currentDate)) {
            // if (!eventDate.after(currentDate)) {
                throw new ApplicationException(new Message(MessageType.WARNING, "W_0003"));
            }

            // 大会情報をDBに登録
            addTournamentRepository.addTournament(request, eventDate);

        } catch (ParseException e) {
            throw new ApplicationException(new Message(MessageType.WARNING, "W_0002"));
        }
    }
}
