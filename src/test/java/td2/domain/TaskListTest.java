package td2.domain;

import org.junit.jupiter.api.Test;
import td2.domain.exeption.TaskListAlreadyExists;
import td2.domain.exeption.TaskListDoesNotExists;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class TaskListTest {

    @Test
    public void StringAndLocalDate_addTask_shouldAddTask() {
        TaskList taskList = new TaskList();

        taskList.addTask("Task 1", LocalDate.now());

        assertFalse(taskList.taskList.isEmpty());
    }

    @Test
    public void StringAndLocalDateAlreadyExsiting_addTask_shouldDoExpeption() {
        TaskList taskList = new TaskList();

        taskList.addTask("Task 1", LocalDate.now());

        assertThrows(TaskListAlreadyExists.class, () -> taskList.addTask("Task 1", LocalDate.now()));
    }

    @Test
    public void StringAndLocalDate_removeTask_shouldRemoveTask() {
        TaskList taskList = new TaskList();

        taskList.addTask("Task 1", LocalDate.now());
        taskList.removeTask("Task 1");

        assertTrue(taskList.taskList.isEmpty());
    }

    @Test
    public void StringAndLocalDate_removeTask_shouldDoExpeption() {
        TaskList taskList = new TaskList();

        assertThrows(TaskListDoesNotExists.class, () -> taskList.removeTask("Task 1"));
    }

    @Test
    public void DeadLine_getTasksByDeadLine_shouldGetTasks() {
        TaskList taskList = new TaskList();
        Task task;
        String taskName = "Task 1";
        LocalDate deadLine = LocalDate.now();

        taskList.addTask(taskName, deadLine);
        taskList.addTask("Task 2", LocalDate.now());

        task = taskList.getTasksByDeadLine(deadLine);

        assertTrue(task.task.equals(taskName));
    }

    @Test
    public void UnknownDeadLine_getTasksByDeadLine_shouldThrowError() {
        TaskList taskList = new TaskList();
        LocalDate deadLine = LocalDate.of(2024, 1, 1);

        taskList.addTask("Task 1", LocalDate.now());
        taskList.addTask("Task 2", LocalDate.now());

        assertThrows(TaskListDoesNotExists.class, () -> taskList.getTasksByDeadLine(deadLine));
    }
}