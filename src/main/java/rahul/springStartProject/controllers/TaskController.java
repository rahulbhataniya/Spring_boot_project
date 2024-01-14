package rahul.springStartProject.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rahul.springStartProject.dto.CreateTaskDto;
import rahul.springStartProject.entities.TaskEntity;
import rahul.springStartProject.service.TaskService;

import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;
    TaskController(TaskService taskService)
    {
        this.taskService=taskService;
    }
    @GetMapping("")
    public ResponseEntity<List<TaskEntity>>getTask()
    {
      var tasks=this.taskService.getTasks();
      return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskEntity>getTaskById(@PathVariable("id") Integer id)
    {
        var task=taskService.getTaskById(id);
        if(task==null)
        {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(task);
    }

    @PostMapping("/AddTask")
    public ResponseEntity<TaskEntity>addTask(@RequestBody CreateTaskDto taskDto)
    {
      var task=taskService.addTask(taskDto.getTitle(),taskDto.getDescription(),taskDto.getDeadline());
      return ResponseEntity.ok(task);
    }

}
