package com.example.TaskMangr.Controler;

import com.example.TaskMangr.Entities.User;
import com.example.TaskMangr.Requests.AddUserReq;
import com.example.TaskMangr.Services.userServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dd/user")
public class UserContoler {

@Autowired
    userServices userServices;
    @PostMapping("/addUser")

    public  String  addUser(@RequestBody AddUserReq addUser){

        return  userServices.addUser(addUser);

    }




}
