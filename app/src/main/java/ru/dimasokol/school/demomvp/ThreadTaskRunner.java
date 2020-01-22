package ru.dimasokol.school.demomvp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTaskRunner implements TaskRunner {

    ExecutorService mExecutor = Executors.newSingleThreadExecutor();

    @Override
    public void runTask(Runnable task) {
        mExecutor.submit(task);
    }
}
