package com.test.sdg.dsgtestapp.first.page.dagger;

import com.test.sdg.dsgtestapp.first.page.model.IMainActivityModel;
import com.test.sdg.dsgtestapp.first.page.model.MainActivityModel;
import com.test.sdg.dsgtestapp.first.page.presenter.MainActivityPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Pankaj Nimgade on 1/28/2018.
 *
 * Module class used by Dagger to inject underlying objects
 */

@Module
public class MainActivityModule {

    @Provides
    @Singleton
    public IMainActivityModel providesMainActivityModel() {
        return new MainActivityModel();
    }

    @Provides
    @Singleton
    public MainActivityPresenter providesMainActivityPresenter(IMainActivityModel model) {
        return new MainActivityPresenter(model);
    }
}
