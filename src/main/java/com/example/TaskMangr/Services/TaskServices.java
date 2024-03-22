package com.example.TaskMangr.Services;

import com.example.TaskMangr.Entities.Task;
import com.example.TaskMangr.Entities.User;
import com.example.TaskMangr.Repository.TaskRepository;
import com.example.TaskMangr.Repository.userRepo;
import com.example.TaskMangr.Requests.AddTaskReq;
import com.example.TaskMangr.Requests.updateTaskReq;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServices {
     @Autowired
     TaskRepository taskRepository;

     @Autowired
    userRepo userRepo;
    public String createTask(AddTaskReq task) {
        Optional<User> user=userRepo.findById(task.getUserId());

        Task newtask=Task.builder()
                .taskStatus(task.getTaskStatus())
                .title(task.getTitle())
                .description(task.getDescription())
                .dueDate(task.getDueDate())
                .build();

        newtask.setUser(user.get());


          user.get().getTaskList().add(newtask);

        newtask=taskRepository.save(newtask);

        return "Task is created ";
    }

    public String updateTask(updateTaskReq updateTaskReq) {
        Integer userId=updateTaskReq.getUserId();
        Integer taskId=updateTaskReq.getTaskId();

        Optional<User> user1=userRepo.findById(userId);
        if(user1.isEmpty()) return "User is not exist";

        Optional<Task> task1=taskRepository.findById(taskId);
        if(task1.isEmpty()) return "task is not there";

        User user=user1.get();

        Task task=task1.get();
        if(task.getUser()!=user){
             return "User dosen't have certian task";
        }

        else   {
             task.setTaskStatus(updateTaskReq.getStatus());
             task.setDueDate(updateTaskReq.getDueDate());
            return "Successfully updated";
        }

    }

    public List<Task> allTasks(Integer userId) throws Exception {
        Optional<User> user1=userRepo.findById(userId);

        if(user1.isEmpty()) throw new Exception("user doesn't exist");
        User user=user1.get();

        List<Task> tasks=user.getTaskList();

        return tasks;

    }

    public List<Task> adminAllTasks() {
       List<Task> tasks= taskRepository.findAll();

        return tasks;

    }
}
