package me.erika.urbandirectory.di.application;

import android.app.Activity;
import android.app.Application;

import me.erika.urbandirectory.di.component.DaggerUrbanDictionaryComponent;
import me.erika.urbandirectory.di.component.UrbanDictionaryComponent;

public class UrbanDirectoryApplication extends Application {

    //add application name in Manifest file
    private UrbanDictionaryComponent urbanDictionaryApplicationComponent;

    public static UrbanDirectoryApplication get(Activity activity){
        return (UrbanDirectoryApplication) activity.getApplication();
    }

    /**
     * The application starts here {@link UrbanDirectoryApplication} and then creates the
     * Component using {@link UrbanDictionaryComponent} where Don Component will be able to see
     * Which screens are going to be part of the graph, in this case {@link me.erika.urbandirectory.view.SearchFragment}
     * Now, SearchFragment needs a ViewModelFactory in order to create the {@link me.erika.urbandirectory.viewmodel.SearchViewModel}
     * so, Don Component will go and see on his drawer which module provides that Object. And he will find out that
     * {@link me.erika.urbandirectory.di.module.ViewModelModule} is how defines (magically due to the abstract thing) how
     * to get the Object.
     *
     * Now the Factory (albanil) {@link me.erika.urbandirectory.di.DaggerViewModelFactory} will try to do his work
     * but now he noticed that {@link me.erika.urbandirectory.viewmodel.SearchViewModel} needs a {@link me.erika.urbandirectory.model.DefinitionRepository}
     * so the Factory (albanil) is going to tell Don component that he needs it, and Don Component again will go and search in his Drawer (Modules)
     * which one can provides that Object.
     *
     * Don Component will find out that {@link me.erika.urbandirectory.di.module.DataModule} is the one that defines how to create that object, but
     * "definitionRepository()" also needs {@link me.erika.urbandirectory.network.UrbanDictionaryAPI}. Once again Don Component will go
     * to his Drawer (Modules) to see how can provides that and he will find out that {@link me.erika.urbandirectory.di.module.UrbanDictionaryModule}
     * is the one that can provide that Object. And at that point Don component will go back and give to the Factory (albanil)
     * the {@link me.erika.urbandirectory.model.DefinitionRepository} created and let him do his work of creating the
     * {@link me.erika.urbandirectory.viewmodel.SearchViewModel}.
     *
     */
    @Override
    public void onCreate() {
        super.onCreate();
        urbanDictionaryApplicationComponent = DaggerUrbanDictionaryComponent.builder().build();
    }



    public UrbanDictionaryComponent getUrbanDictionaryApplicationComponent(){
        return urbanDictionaryApplicationComponent;
    }

}
