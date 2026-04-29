package cl.duoc.taskflow.repository;

import cl.duoc.taskflow.model.Task;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TaskRepository {
    // Mapa para evitar duplicados y asegurar tipos controlados [cite: 36, 39, 57]
    private final Map<String, Task> tasks = new ConcurrentHashMap<>();

    public Task save(Task task) {
        tasks.put(task.getId(), task);
        return task;
    }

    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    public Optional<Task> findById(String id) {
        return Optional.ofNullable(tasks.get(id));
    }

    public void deleteById(String id) {
        tasks.remove(id);
    }
}

