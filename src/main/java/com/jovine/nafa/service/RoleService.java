package com.jovine.nafa.service;

import com.jovine.nafa.entity.Role;
import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepo;

    public ResponseEntity<StandardResponse> createNewRole(Role role) {
        try {
            return StandardResponse.sendHttpResponse(true, "Operation was successful",
                    roleRepo.save(role), "200");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not create role");
        }
    }

    public ResponseEntity<StandardResponse> getAllRoles() {
        try {

            List<Role> roles = roleRepo.findAll();
            return StandardResponse.sendHttpResponse(true, "Operation was successful",
                    roles, "200");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get roles");
        }
    }
}
