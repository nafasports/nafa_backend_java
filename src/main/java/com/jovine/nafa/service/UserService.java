package com.jovine.nafa.service;

import com.jovine.nafa.entity.StandardResponse;
import com.jovine.nafa.repository.RoleRepository;
import com.jovine.nafa.entity.Role;
import com.jovine.nafa.entity.User;
import com.jovine.nafa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void initRoleAndUser() {

        Role adminRole = new Role();
        adminRole.setRoleName("Admin");
        adminRole.setRoleDescription("Admin role");
        roleRepo.save(adminRole);

        Role userRole = new Role();
        userRole.setRoleName("User");
        userRole.setRoleDescription("Default role for newly created record");
        roleRepo.save(userRole);

        User adminUser = new User();
        adminUser.setUserName("admin123");
        adminUser.setUserPassword(passwordEncoder.encode("admin@pass"));
        adminUser.setUserFirstName("admin");
        adminUser.setUserLastName("admin");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(adminRole);
        adminUser.setRole(adminRoles);
        userRepo.save(adminUser);

    }

    public ResponseEntity<StandardResponse> registerNewUser(User user) {
        try {
            Role role = roleRepo.findByRoleName("User").get();
            Set<Role> roles = new HashSet<>();
            roles.add(role);

            boolean loggedUser = userRepo.findByUserName(user.getUserName()).isPresent();
            if(!loggedUser) {
                user.setRole(roles);
                user.setTag("User");
                user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));

                User savedUser = userRepo.save(user);
                return StandardResponse.sendHttpResponse(true, "Operation successful!", savedUser, "200");
            }else{
                return StandardResponse.sendHttpResponse(false, "User already exists");
            }
        } catch (Exception e) {

            return StandardResponse.sendHttpResponse(false, "Could not save user");
        }
    }

    public ResponseEntity<StandardResponse> registerNewAdmin(User adminUser) {
        return null;
    }

    public ResponseEntity<StandardResponse> getAllUsers() {
        try {
            List<User> userList =  userRepo.findAll();
            return StandardResponse.sendHttpResponse(true, "Operation successful",
                    userList, "200");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not get users");
        }
    }

    public ResponseEntity<StandardResponse> deleteUser(Long id) {
        try {
            userRepo.deleteById(id);
            return StandardResponse.sendHttpResponse(true, "Operation successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete user");
        }
    }

    public ResponseEntity<StandardResponse> deleteAllUsers() {
        try {
            userRepo.deleteAll();
            return StandardResponse.sendHttpResponse(true, "Operation successful");
        } catch (Exception e) {
            return StandardResponse.sendHttpResponse(false, "Could not delete user");
        }
    }

    public ResponseEntity<StandardResponse> updateUser(User user) {

        User userDB = userRepo.findById(user.getId()).get();
        if(Objects.nonNull(user.getUserFirstName()) && !"".equalsIgnoreCase(user.getUserFirstName())) {
            userDB.setUserFirstName(user.getUserFirstName());
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

        return StandardResponse.sendHttpResponse(true, "Successfully updated", userRepo.save(userDB), "200");
    }
}

