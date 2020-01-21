package me.erika.urbandirectory.di.component;

import javax.inject.Scope;

import dagger.Component;
import me.erika.urbandirectory.di.interfaces.UrbanDictionaryApplicationScope;
import me.erika.urbandirectory.di.module.UrbanDictionaryModule;
import me.erika.urbandirectory.network.UrbanDictionaryAPI;

@UrbanDictionaryApplicationScope
@Component(modules = {UrbanDictionaryModule.class})
public interface UrbanDictionaryComponent {

    UrbanDictionaryAPI urbanDictionaryService();
}
