package com.example.TaskMangr.Requests;


import lombok.Data;

@Data
public class AddUserReq {
    private String name;
    private String password;
    private String role;

    public AddUserReq(String name, String password, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
    }
}
