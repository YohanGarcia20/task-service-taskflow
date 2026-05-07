package cl.duoc.taskflow.service;
import cl.duoc.taskflow.dto.TaskDTO;
import cl.duoc.taskflow.model.Task;
import cl.duoc.taskflow.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task create(TaskDTO dto) {
        Task task = new Task();
        task.setId(UUID.randomUUID().toString());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setPriority(dto.getPriority());
        task.setResponsible(dto.getResponsible());
        task.setDueDate(dto.getDueDate());
        return repository.save(task);
    }
    public List<Task> getAll() {
        return repository.findAll();
    }


    public List<Task> filterByStatus(String status) {
        return repository.findAll().stream()
                .filter(t -> t.getStatus().equalsIgnoreCase(status))
                .collect(Collectors.toList());
    }

    public boolean delete(String id) {
        if (repository.findById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Task> findById(String id) {
        return repository.findById(id);
    }


    public Optional<Task> update(String id, TaskDTO dto) {
        return repository.findById(id).map(existingTask -> {

            existingTask.setDescription(dto.getDescription());
            existingTask.setStatus(dto.getStatus());
            existingTask.setPriority(dto.getPriority());
            existingTask.setResponsible(dto.getResponsible());
            existingTask.setDueDate(dto.getDueDate());


            return repository.save(existingTask);
        });
    }
}



