package me.erika.urbandirectory.di.module;

import dagger.Module;
import dagger.Provides;
import me.erika.urbandirectory.di.interfaces.UrbanDictionaryApplicationScope;
import me.erika.urbandirectory.model.DefinitionRepository;
import me.erika.urbandirectory.network.UrbanDictionaryAPI;

@Module
public class DataModule {


    @UrbanDictionaryApplicationScope
    @Provides
    public DefinitionRepository definitionRepository(UrbanDictionaryAPI service){
        return new DefinitionRepository(service);

    }
}
