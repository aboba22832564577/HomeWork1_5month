package com.geektech.homework1_5month.helper;

import com.geektech.homework1_5month.model.CounterModel;
import com.geektech.homework1_5month.presenter.Presenter;

public class Injector {

    public static Presenter getPresenter(){
        return new Presenter();
    }

    public static CounterModel getModel(){
        return new CounterModel();
    }
}
