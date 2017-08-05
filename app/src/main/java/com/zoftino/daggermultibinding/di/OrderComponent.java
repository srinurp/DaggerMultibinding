package com.zoftino.daggermultibinding.di;

import com.zoftino.daggermultibinding.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = OrderModule.class)
public interface OrderComponent {
    void inject(MainActivity mainActivity);
}
