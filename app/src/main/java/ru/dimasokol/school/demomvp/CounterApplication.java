package ru.dimasokol.school.demomvp;

import android.app.Application;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.Map;

public class CounterApplication extends Application {

    private Map<Class<? extends BasePresenter>, BasePresenter> mPresenters = new HashMap<>();

    @NonNull
    public <P extends BasePresenter> P getPresenter(Class<P> clazz) {
        P presenter = (P) mPresenters.get(clazz);

        if (presenter == null) {
            presenter = (P) new CounterPresenter(new UiThreadNotifier(), CounterModel.getInstance());
            mPresenters.put(clazz, presenter);
        }

        return presenter;
    }

}
