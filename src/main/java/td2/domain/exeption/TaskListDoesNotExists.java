package td2.domain.exeption;

public class TaskListDoesNotExists extends RuntimeException {

    public TaskListDoesNotExists() {
        super("TaskList does not exist");
    }
}
