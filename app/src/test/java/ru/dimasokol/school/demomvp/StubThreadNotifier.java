package ru.dimasokol.school.demomvp;

public class StubThreadNotifier implements ThreadNotifier {
    @Override
    public void runOnTargetThread(Runnable code) {
        code.run();
    }
}
