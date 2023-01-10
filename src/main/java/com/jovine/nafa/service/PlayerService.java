package com.jovine.nafa.service;

import com.jovine.nafa.entity.Player;
import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public ResponseEntity<StandardResponse> registerNewPlayer(Player player) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", playerRepository.save(player));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not register Player");
        }
    }

    public ResponseEntity<StandardResponse> getPlayerById(Long playerId) {
        try {
            Player play = playerRepository.findById(playerId).get();
            return StandardResponse.sendHttpResponse(true, "Successful", play);
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get players");
        }
    }

    public ResponseEntity<StandardResponse> getAllPlayers() {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", playerRepository.findAll());
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get all players");
        }
    }

    public ResponseEntity<StandardResponse> updatePlayer(Player player) {
        try {
            Player playerDB = playerRepository.findById(player.getPlayerId()).get();

            if(Objects.nonNull(player.getFirstName()) && !"".equalsIgnoreCase(player.getFirstName())) {
                playerDB.setFirstName(player.getFirstName());
            }

            if(Objects.nonNull(user.getUserLastName()) && !"".equalsIgnoreCase(user.getUserLastName())) {
                userDB.setUserLastName(user.getUserLastName());
            }

            if(Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) {
                userDB.setEmail(user.getEmail());
            }

            if(Objects.nonNull(user.getPhoneNumber()) && !"".equalsIgnoreCase(user.getPhoneNumber())) {
                userDB.setPhoneNumber(user.getPhoneNumber());
            }

            if(Objects.nonNull(user.getStaffId()) && !"".equalsIgnoreCase(user.getStaffId())) {
                userDB.setStaffId(user.getStaffId());
            }
            return StandardResponse.sendHttpResponse(true, "Successful", playerRepository.save(playerDB));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not update player");
        }
    }

    public ResponseEntity<StandardResponse> deletePlayer(Long playerId) {
        try {
            playerRepository.deleteById(playerId);
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete Player");
        }
    }

    public ResponseEntity<StandardResponse> deleteAllPlayers(){
        try {
            playerRepository.deleteAll();
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete all players");
        }
    }
}
