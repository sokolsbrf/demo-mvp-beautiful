package ru.dimasokol.school.demomvp;

abstract class BasePresenter<V> {
    public abstract void attachView(V view);

    public abstract void detachView();
}
