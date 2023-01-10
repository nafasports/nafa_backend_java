package com.jovine.nafa.service;

import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.entity.Teams;
import com.jovine.nafa.repository.TeamsRepo;
import io.swagger.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TeamService {
    @Autowired
    private TeamsRepo teamsRepo;

    public ResponseEntity<StandardResponse> createTeam(Teams team) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", teamsRepo.save(team));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return StandardResponse.sendHttpResponse(false, "Could not create team");
        }
    }

    public ResponseEntity<StandardResponse> getTeamById(Long teamId){
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", teamsRepo.findById(teamId));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false,"Could not get team");
        }
    }

    public ResponseEntity<StandardResponse> getAllTeams(){
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", teamsRepo.findAll());
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get All teams");
        }
    }

    public ResponseEntity<StandardResponse> updateTeamDetails(Teams teams){
        try {
            Teams teamDB = teamsRepo.findById(teams.getTeamId()).get();
//            if(Objects.nonNull(player.getFirstName()) && !"".equalsIgnoreCase(player.getFirstName())) {
//                playerDB.setFirstName(playerDB.getFirstName());
//            }
//
//            if(Objects.nonNull(user.getUserLastName()) && !"".equalsIgnoreCase(user.getUserLastName())) {
//                userDB.setUserLastName(user.getUserLastName());
//            }
//
//            if(Objects.nonNull(user.getEmail()) && !"".equalsIgnoreCase(user.getEmail())) {
//                userDB.setEmail(user.getEmail());
//            }
//
//            if(Objects.nonNull(user.getPhoneNumber()) && !"".equalsIgnoreCase(user.getPhoneNumber())) {
//                userDB.setPhoneNumber(user.getPhoneNumber());
//            }
//
//            if(Objects.nonNull(user.getStaffId()) && !"".equalsIgnoreCase(user.getStaffId())) {
//                userDB.setStaffId(user.getStaffId());
//            }
            return StandardResponse.sendHttpResponse(true, "Successful", teamsRepo.save(teamDB));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not update Teams details");
        }
    }

    public ResponseEntity<StandardResponse> deleteTeam(Long teamId){
        try {
            teamsRepo.deleteById(teamId);
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Coudl not delete Team");
        }
    }

    public ResponseEntity<StandardResponse> deleteAllTeams(){
        try {
            teamsRepo.deleteAll();
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete all teams");
        }
    }
}
