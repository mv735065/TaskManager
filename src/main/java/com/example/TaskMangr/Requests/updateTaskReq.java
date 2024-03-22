package com.example.TaskMangr.Requests;

import com.example.TaskMangr.Enums.TaskStatus;
import lombok.Data;

import java.util.Date;
@Data
public class updateTaskReq {

    private  Integer taskId;
    private TaskStatus status;

    private Date dueDate;
    private Integer userId;
}
