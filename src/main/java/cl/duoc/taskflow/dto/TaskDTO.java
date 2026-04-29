package cl.duoc.taskflow.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;


public class TaskDTO {
    @NotBlank(message = "La descripción no puede estar vacía")
    private String description;

    @NotBlank(message = "El estado es obligatorio")
    private String status;

    @NotBlank(message = "La prioridad es obligatoria")
    private String priority;

    @NotBlank(message = "El responsable es obligatorio")
    private String responsible;

    @NotNull(message = "La fecha de vencimiento es obligatoria")
    private LocalDate dueDate;

    // Getters y Setters...


    public @NotNull(message = "La fecha de vencimiento es obligatoria") LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(@NotNull(message = "La fecha de vencimiento es obligatoria") LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public @NotBlank(message = "El responsable es obligatorio") String getResponsible() {
        return responsible;
    }

    public void setResponsible(@NotBlank(message = "El responsable es obligatorio") String responsible) {
        this.responsible = responsible;
    }

    public @NotBlank(message = "La prioridad es obligatoria") String getPriority() {
        return priority;
    }

    public void setPriority(@NotBlank(message = "La prioridad es obligatoria") String priority) {
        this.priority = priority;
    }

    public @NotBlank(message = "El estado es obligatorio") String getStatus() {
        return status;
    }

    public void setStatus(@NotBlank(message = "El estado es obligatorio") String status) {
        this.status = status;
    }

    public String getDescription() {return description;}

    public void setDescription(String description) {
        this.description = description;}
    }

