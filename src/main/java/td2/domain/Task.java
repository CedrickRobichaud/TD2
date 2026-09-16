package td2.domain;

import java.time.LocalDate;

public class Task {
    String task;
    LocalDate deadline;
    public Task (String task, LocalDate deadline) {
        this.task = task;
        this.deadline = deadline;
    }
}
