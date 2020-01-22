package ru.dimasokol.school.demomvp;

public class StubTaskRunner implements TaskRunner {
    @Override
    public void runTask(Runnable task) {
        task.run();
    }
}
