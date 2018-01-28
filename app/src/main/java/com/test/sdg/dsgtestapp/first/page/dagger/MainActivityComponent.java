package com.test.sdg.dsgtestapp.first.page.dagger;

import com.test.sdg.dsgtestapp.first.page.presenter.MainActivityPresenter;
import com.test.sdg.dsgtestapp.first.page.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Pankaj Nimgade on 1/28/2018.
 */

@Singleton
@Component(modules = {MainActivityModule.class})
public interface MainActivityComponent {

    MainActivityPresenter getMainActivityPresenter();

    void inject(MainActivity view);
}
