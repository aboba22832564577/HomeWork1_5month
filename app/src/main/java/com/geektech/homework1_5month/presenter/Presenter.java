package com.geektech.homework1_5month.presenter;

import com.geektech.homework1_5month.helper.Injector;
import com.geektech.homework1_5month.model.CounterModel;
import com.geektech.homework1_5month.view.Contracts;

public class Presenter {

    CounterModel model = Injector.getModel();
    Contracts.CounterView view;

    public void increment(){
        model.plus();
        view.updateText(model.getCount());

        if (model.getCount() == 10){
            view.showToast();
        }

        if (model.getCount() == 15){
            view.changeColor();
        } else {
            view.changeBack();
        }
    }

    public void decrement(){
        model.minus();
        view.updateText(model.getCount());

        if (model.getCount() == 10){
            view.showToast();
        }

        if (model.getCount() == 15){
           view.changeColor();
        } else {
            view.changeBack();
        }
    }
    public void attachView(Contracts.CounterView view){
        this.view = view;
    }
}
