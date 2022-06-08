package com.geektech.homework1_5month;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.GREEN;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.geektech.homework1_5month.databinding.ActivityMainBinding;
import com.geektech.homework1_5month.helper.Injector;
import com.geektech.homework1_5month.presenter.Presenter;
import com.geektech.homework1_5month.view.Contracts;

public class MainActivity extends AppCompatActivity implements Contracts.CounterView {

    ActivityMainBinding binding;
    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = Injector.getPresenter();
        presenter.attachView(this);
        initListeners();
    }

    private void initListeners() {
        binding.btnPlus.setOnClickListener(v -> presenter.increment());

        binding.btnMinus.setOnClickListener(v -> presenter.decrement());
    }

    @Override
    public void updateText(int count) {
        binding.tvNumber.setText(String.valueOf(count));
    }

    @Override
    public void showToast() {
        Toast.makeText(this, "Поздравляем", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void changeColor() {
            binding.tvNumber.setTextColor(GREEN);
    }

    @Override
    public void changeBack() {
        binding.tvNumber.setTextColor(BLACK);
    }
}