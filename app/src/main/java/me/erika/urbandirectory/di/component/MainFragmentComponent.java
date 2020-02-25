package me.erika.urbandirectory.di.component;


import dagger.Subcomponent;
import me.erika.urbandirectory.di.module.MainFragmentModule;
import me.erika.urbandirectory.view.SearchFragment;

@Subcomponent(modules = MainFragmentModule.class)
public interface MainFragmentComponent {

    void injectMainFragment(SearchFragment searchFragment);
}
