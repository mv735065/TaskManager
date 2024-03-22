package com.example.TaskMangr.Controler;

import com.example.TaskMangr.Entities.Task;
import com.example.TaskMangr.Requests.AddTaskReq;
import com.example.TaskMangr.Requests.updateTaskReq;
import com.example.TaskMangr.Services.TaskServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task1")
public class TaskControler {
@Autowired
    TaskServices taskServices;
    @PostMapping("/user/addTask")
    public String createTask(@RequestBody AddTaskReq addTask){


        return taskServices.createTask(addTask);

    }

    @PostMapping("/user/updateTask")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public String updateTask(@RequestBody updateTaskReq updateTaskReq){


       return taskServices. updateTask(updateTaskReq);
    }

    @GetMapping("/user/allTasksUser")
    @PreAuthorize("(#userId == principal.username) and (hasRole('ROLE_ADMIN') or hasRole('ROLE_USER'))")
    public List<Task>  allTasks(@RequestParam Integer userId) throws Exception {
        List<Task> tasks;
  try{
      tasks=  taskServices.allTasks(userId);

  }
  catch (Exception e){
      return (List<Task>) new Exception(e.getMessage());
  }
       return tasks;

    }


    @GetMapping("/admin/allTasks")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public List<Task>  adminAllTasks() throws Exception
    {
        try{
            List<Task> tasks=taskServices.adminAllTasks();
            return tasks;
        }
        catch (Exception e){
            return (List<Task>) new Exception(e.toString());
        }

    }

}
