package cl.duoc.taskflow.controller;
import cl.duoc.taskflow.dto.TaskDTO;
import cl.duoc.taskflow.model.Task;
import cl.duoc.taskflow.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {
    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Task> create(@Valid @RequestBody TaskDTO dto) {
        // Retorna 201 Created al registrar exitosamente [cite: 67, 139]
        return new ResponseEntity<>(service.create(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Task>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/status/{status}") // Ruta semántica [cite: 167]
    public ResponseEntity<List<Task>> getByStatus(@PathVariable String status) {
        return ResponseEntity.ok(service.filterByStatus(status));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (service.delete(id)) {
            return ResponseEntity.noContent().build(); // 204 No Content
        }
        return ResponseEntity.notFound().build(); // 404 Not Found [cite: 139]
    }
}
