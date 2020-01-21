package me.erika.urbandirectory.di.module;

import android.app.Activity;
import android.content.Context;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import me.erika.urbandirectory.di.interfaces.UrbanDictionaryApplicationScope;

@Module
public class ActivityContextModule {

    private final Context context;

    ActivityContextModule(Activity context){
        this.context = context;
    }

    @Named("activity_context")
    @UrbanDictionaryApplicationScope
    @Provides
    public Context context(){
        return context;
    }


}
