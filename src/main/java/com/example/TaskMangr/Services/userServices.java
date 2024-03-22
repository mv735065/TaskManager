package com.example.TaskMangr.Services;

import com.example.TaskMangr.Entities.User;
import com.example.TaskMangr.Repository.userRepo;
import com.example.TaskMangr.Requests.AddUserReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class userServices implements UserDetailsService {

@Autowired
    userRepo userRepo;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> userDetail = userRepo.findByName(username);

        // Converting userDetail to UserDetails
        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found " + username));
    }


    public String addUser(AddUserReq addUser) {

        User userInfo=User.builder()
                .userName(addUser.getName())
                .role(addUser.getRole())
                .password(addUser.getPassword())
                .build();
        userInfo.setPassword(encoder.encode(userInfo.getPassword()));
        userRepo.save(userInfo);



        return "User Added Successfully";
    }

}
