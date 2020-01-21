package me.erika.urbandirectory.di.module;

import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import me.erika.urbandirectory.di.interfaces.UrbanDictionaryApplicationScope;

@Module
public class ContextModule {

    Context context;

    public ContextModule(Context context){
        this.context = context;
    }

    @Named("application_context")
    @UrbanDictionaryApplicationScope
    @Provides
    public Context context(){
        return context.getApplicationContext();
    }
}
