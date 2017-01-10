package com.scottiebiddle.commutestats;

import com.scottiebiddle.commutestats.db.DatabaseModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by scottie on 1/9/17.
 */
@Singleton
@Component(modules = {AppModule.class, DatabaseModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

}
