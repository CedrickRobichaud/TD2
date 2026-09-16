package td2.domain.exeption;

public class TaskListAlreadyExists extends RuntimeException {

    public TaskListAlreadyExists() {
        super("TaskList already exists");
    }
}
