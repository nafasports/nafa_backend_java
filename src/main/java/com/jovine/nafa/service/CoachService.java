package com.jovine.nafa.service;

import com.jovine.nafa.entity.Coach;
import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.repository.CoachRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.Objects;

@Service
public class CoachService {
    @Autowired
    private CoachRepository coachRepository;

    public ResponseEntity<StandardResponse> createCoach(Coach coach) {
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", coachRepository.save(coach));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not create coach");
        }
    }

    public ResponseEntity<StandardResponse> getCoach(Long coachId){
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", coachRepository.findById(coachId));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Coulc not get Coach details");
        }
    }

    public ResponseEntity<StandardResponse> getAllCoaches(){
        try {
            return StandardResponse.sendHttpResponse(true, "Successful", coachRepository.findAll());
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get all coaches");
        }
    }

    public ResponseEntity<StandardResponse> updateCoachDetails(Coach coach){
        try {
            Coach coachDB = coachRepository.findById(coach.getCoachId()).get();
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
            return StandardResponse.sendHttpResponse(true, "Successful", coachRepository.save(coachDB));
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not update coach details");
        }
    }

    public ResponseEntity<StandardResponse> deleteCoach(Long coachId){
        try {
            coachRepository.deleteById(coachId);
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete coach");
        }
    }

    public ResponseEntity<StandardResponse> deleteAllCoaches(){
        try {
            coachRepository.deleteAll();
            return StandardResponse.sendHttpResponse(true, "Successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete All coaches");
        }
    }
}
