package ru.dimasokol.school.demomvp;

import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;

public class ThreadTaskRunnerTest {

    private CountDownLatch mLatch;
    private ThreadTaskRunner mTaskRunner;

    @Before
    public void setUp() throws Exception {
        mTaskRunner = new ThreadTaskRunner();
        mLatch = new CountDownLatch(1);
    }

    @Test(timeout = 1000)
    public void runTask() throws InterruptedException {
        mTaskRunner.runTask(new Runnable() {
            @Override
            public void run() {
                mLatch.countDown();
            }
        });

        mLatch.await();
    }
}