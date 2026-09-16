package td2.domain;

import td2.domain.exeption.TaskListAlreadyExists;
import td2.domain.exeption.TaskListDoesNotExists;

import java.time.LocalDate;
import java.util.List;

public class TaskList {
    List<Task> taskList = new java.util.ArrayList<>();

    public void addTask(String task, LocalDate deadline) {
        if  (findByTask(task) ) {
            throw new TaskListAlreadyExists();
        }

        Task taskToAdd = new Task(task, deadline);
        taskList.add(taskToAdd);
    }

    public void removeTask(String task) {
        if  (!findByTask(task) ) {
            throw new TaskListDoesNotExists();
        }

        taskList.removeIf(t -> t.task.equals(task));
    }

    public Task getTasksByDeadLine(LocalDate LocalDate) {
        Task task = taskList.stream()
                .filter(t -> t.deadline.equals(LocalDate))
                .findFirst()
                .orElse(null);
        if (task == null) {
            throw new TaskListDoesNotExists();
        } else {
            return task;
        }
    }

    public boolean findByTask(String task){
        if (taskList.isEmpty()){
            return false;
        }
        return TaskList.this.taskList.stream().anyMatch(t -> t.task.equals(task));
    }

}
