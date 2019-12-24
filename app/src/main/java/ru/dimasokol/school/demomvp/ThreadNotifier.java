package ru.dimasokol.school.demomvp;

public interface ThreadNotifier {

    void runOnTargetThread(Runnable code);

}
