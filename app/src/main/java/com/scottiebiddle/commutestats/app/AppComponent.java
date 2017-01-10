package com.scottiebiddle.commutestats.app;

import com.scottiebiddle.commutestats.MainActivity;
import com.scottiebiddle.commutestats.db.DatabaseModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Application Component
 */
@Singleton
@Component(modules = {AppModule.class, DatabaseModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

}
