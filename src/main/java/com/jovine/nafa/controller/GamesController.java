package com.jovine.nafa.controller;

import com.jovine.nafa.entity.Games;
import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.service.GamesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/games")
public class GamesController {
    @Autowired
    private GamesService gamesService;

    @PostMapping("/creategames")
    public ResponseEntity<StandardResponse> createGame(@RequestBody Games game){
        return gamesService.createGame(game);
    }
    @GetMapping("/getgame")
    public ResponseEntity<StandardResponse> getGame(@RequestParam("gameId") Long gameId){
        return gamesService.getGameById(gameId);
    }
    @GetMapping("/getgamesbydate")
    public ResponseEntity<StandardResponse> gamesByDate(@RequestParam("gameDate")LocalDateTime gameDate){
        return gamesService.getGamesByDate(gameDate);
    }
    @GetMapping("/getgamesbyadaterange")
    public ResponseEntity<StandardResponse> gamesByRange(@RequestParam("startDate")LocalDateTime startDate, @RequestParam("endDate")LocalDateTime endDate){
        return gamesService.getGamesByDateRange(startDate, endDate);
    }
    @DeleteMapping("/deletegame")
    public ResponseEntity<StandardResponse> deleteGame(@RequestParam("gameId") Long gameId){
        return gamesService.deleteGame(gameId);
    }
    @DeleteMapping("/deleteallgames")
    public ResponseEntity<StandardResponse> deleteallgames(){
        return gamesService.deleteAllGames();
    }
}
