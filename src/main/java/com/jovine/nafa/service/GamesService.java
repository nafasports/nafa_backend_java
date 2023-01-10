package com.jovine.nafa.service;

import com.jovine.nafa.entity.Games;
import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.repository.GamesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class GamesService {
    @Autowired
    private GamesRepository gamesRepo;

    public ResponseEntity<StandardResponse> createGame(Games game) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", gamesRepo.save((game)));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not create game");
        }
    }


    public ResponseEntity<StandardResponse> getGameById(Long gameId) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", gamesRepo.findById(gameId));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false,"Could not get the game");
        }
    }


    public ResponseEntity<StandardResponse> getGamesByDate(LocalDateTime gameDate) {
        try {
            List<Games> gamesList = gamesRepo.findByGameDate(gameDate);
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get game");
        }
    }

    public ResponseEntity<StandardResponse> getGamesByDateRange(LocalDateTime startDate, LocalDateTime endDate) {
        try {
            List<Games> gamesList = gamesRepo.findByGameDateGreaterThanEqualAndGameDateLessThanEqual(startDate,endDate);
            return StandardResponse.sendHttpResponse(true, "Successful", gamesList);
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get games in this range");
        }
    }

    public ResponseEntity<StandardResponse> deleteGame(Long gameId) {
        try {
            gamesRepo.deleteById(gameId);
            return StandardResponse.sendHttpResponse(true, "Successfully deleted");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete game");
        }
    }

    public ResponseEntity<StandardResponse> deleteAllGames(){
        try {
            gamesRepo.deleteAll();
            return StandardResponse.sendHttpResponse(true, "Successfully deleted");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete all games");
        }
    }
}
