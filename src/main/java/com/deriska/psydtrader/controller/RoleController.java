package com.deriska.psydtrader.controller;

import com.deriska.psydtrader.entity.Role;
import com.deriska.psydtrader.entity.StandardResponse;
import com.deriska.psydtrader.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping({"/createnewrole"})
    public ResponseEntity<StandardResponse> createNewRole(@RequestBody Role role) {
        return roleService.createNewRole(role);
    }

    @GetMapping("/getallroles")
    public ResponseEntity<StandardResponse> getAllRoles(){
        return roleService.getAllRoles();
    }
}
