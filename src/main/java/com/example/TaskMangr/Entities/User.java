package com.example.TaskMangr.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "user")
@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    private  String userName;

    private String password;
    private String role;

 @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Task> taskList = new ArrayList<>();

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

}
