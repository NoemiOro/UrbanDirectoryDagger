package me.erika.urbandirectory.di.component;

import dagger.Component;
import me.erika.urbandirectory.di.interfaces.UrbanDictionaryApplicationScope;
import me.erika.urbandirectory.di.module.DataModule;
import me.erika.urbandirectory.di.module.UrbanDictionaryModule;
import me.erika.urbandirectory.di.module.ViewModelModule;
import me.erika.urbandirectory.view.SearchFragment;

@UrbanDictionaryApplicationScope
@Component(modules = {UrbanDictionaryModule.class, ViewModelModule.class, DataModule.class})
public interface UrbanDictionaryComponent {
    void inject(SearchFragment searchFragment);
}
