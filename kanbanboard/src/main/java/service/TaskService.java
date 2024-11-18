package service;

import model.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Service;
import repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return (Task) (Task) taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Object updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

    public Object moveTask(Long id) throws Throwable {
        Task task = (Task) taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarefa não encontrada"));
        if (task.getClass() == TaskStatus.TODO) {
            task.getClass(TaskStatus.IN_PROGRESS);
        } else if (task.getClass() == TaskStatus.IN_PROGRESS) {
            task.getClass(TaskStatus.DONE);
        }
        return (Task) (Task) (Task) taskRepository.save(task);
    }
}
