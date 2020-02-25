package me.erika.urbandirectory.di.component;

import dagger.Component;
import me.erika.urbandirectory.di.interfaces.UrbanDictionaryApplicationScope;
import me.erika.urbandirectory.di.module.DataModule;
import me.erika.urbandirectory.di.module.MainFragmentModule;
import me.erika.urbandirectory.di.module.UrbanDictionaryModule;
import me.erika.urbandirectory.di.module.ViewModelModule;
import me.erika.urbandirectory.view.SearchFragment;

@UrbanDictionaryApplicationScope
@Component(modules = {UrbanDictionaryModule.class, ViewModelModule.class, DataModule.class})
public interface UrbanDictionaryComponent {
    //No need to expose main fragment here because main fragment component is a subcomponent so it gets access to all services in
    //UrbanDictionaryComponent.
    //All subcomponents should be connected here and send their modules as parameters.
   MainFragmentComponent newMainFragmentComponent(MainFragmentModule mainFragmentModule);
}
