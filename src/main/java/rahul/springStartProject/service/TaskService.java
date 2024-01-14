package rahul.springStartProject.service;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import rahul.springStartProject.entities.TaskEntity;

import java.util.ArrayList;
import java.util.Date;

@Service
public class TaskService {
    private ArrayList<TaskEntity> tasks = new ArrayList<>();
    private int taskId = 1;
    public ArrayList<TaskEntity> getTasks() {
        return tasks;
    }

    public TaskEntity getTaskById(int id)
    {
        for(TaskEntity task:tasks)
        {
            if(task.getId()==id) {
                return task;
            }
        }
        return null;
    }

    public void setTasks(ArrayList<TaskEntity> tasks) {
        this.tasks = tasks;
    }

    public TaskEntity addTask(String title, String description, String deadline) {
        TaskEntity task = new TaskEntity();
       // task.setDeadline(new Date(deadline)); // validate date format
        task.setId(taskId);
        task.setDescription(description);
        task.setTitle(title);
        task.setCompleted(false);

        // Add the task to the list
        tasks.add(task);
        taskId++;
        return task;
    }
}
