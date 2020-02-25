package me.erika.urbandirectory.di.module;

import dagger.Module;
import dagger.Provides;
import me.erika.urbandirectory.view.DefinitionsAdapter;

@Module
public class MainFragmentModule {
    @Provides
    public DefinitionsAdapter definitionsAdapter(){
        return new DefinitionsAdapter();
    }
}
