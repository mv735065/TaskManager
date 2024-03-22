package com.example.TaskMangr.Requests;

import com.example.TaskMangr.Enums.TaskStatus;
import lombok.Data;

import java.util.Date;

@Data
public class AddTaskReq {

    private String title;
    private String description;
    private Date dueDate;
    private TaskStatus taskStatus;


    private Integer userId;

}
