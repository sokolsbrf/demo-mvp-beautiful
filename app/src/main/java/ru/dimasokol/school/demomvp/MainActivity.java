package ru.dimasokol.school.demomvp;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements CounterView {

    private TextView mCountView;
    private View mIncrementButton;

    private CounterPresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = ((CounterApplication) getApplication()).getPresenter(CounterPresenter.class);

        mCountView = findViewById(R.id.text_count);
        mIncrementButton = findViewById(R.id.button_increment);

        mIncrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.increment();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.detachView();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter = null;
    }

    @Override
    public void setCount(int count) {
        mCountView.setText(Integer.toString(count));
    }
}
