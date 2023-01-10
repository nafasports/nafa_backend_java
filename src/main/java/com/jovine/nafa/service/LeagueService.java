package com.jovine.nafa.service;

import com.jovine.nafa.entity.Leagues;
import com.jovine.nafa.entity.Pojo.LeagueAndTeams;
import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.entity.Teams;
import com.jovine.nafa.repository.LeagueRepository;
import com.jovine.nafa.repository.TeamsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class LeagueService {
    @Autowired
    private LeagueRepository leagueRepo;
    @Autowired
    private TeamsRepo teamsRepo;

    public ResponseEntity<StandardResponse> createLeague(Leagues league) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", leagueRepo.save(league));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not create League");
        }
    }

    public ResponseEntity<StandardResponse> getLeagueById(Long leagueId) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", leagueRepo.findById(leagueId));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get League info");
        }
    }

    public ResponseEntity<StandardResponse> getLeagueAndTeams(Long leagueId) {
        try {
            Leagues league = leagueRepo.findById(leagueId).get();
            List<Teams> teamsList = teamsRepo.findByLeagueId(league.getLeagueId());
            LeagueAndTeams leagueTeams = new LeagueAndTeams();
            leagueTeams.setLeague(league);
            leagueTeams.setLeagueTeams(teamsList);
            return StandardResponse.sendHttpResponse(true, "Successful", leagueTeams);
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get the teams and leagues");
        }
    }

    public ResponseEntity<StandardResponse> getAllLeagues() {
        try {
            return StandardResponse.sendHttpResponse(true,"Successful", leagueRepo.findAll());
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get All leagues");
        }
    }


    public ResponseEntity<StandardResponse> updateLeague(Leagues league) {
        try {
            Leagues leagueDB = leagueRepo.findById(league.getLeagueId()).get();
            if(Objects.nonNull(player.getFirstName()) && !"".equalsIgnoreCase(player.getFirstName())) {
                playerDB.setFirstName(playerDB.getFirstName());
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
            return StandardResponse.sendHttpResponse(true, "Successful", leagueRepo.save(leagueDB));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not update League info");
        }
    }

    public ResponseEntity<StandardResponse> deleteLeague(Long leagueId){
        try {
            leagueRepo.deleteById(leagueId);
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete league");
        }
    }

    public ResponseEntity<StandardResponse> deleteAllLeagues(){
        try {
            leagueRepo.deleteAll();
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return StandardResponse.sendHttpResponse(false, "Could not delete All leagues");
        }
    }
}
