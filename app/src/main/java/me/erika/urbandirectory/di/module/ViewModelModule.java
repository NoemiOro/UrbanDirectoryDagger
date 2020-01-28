package me.erika.urbandirectory.di.module;


import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import me.erika.urbandirectory.di.DaggerViewModelFactory;
import me.erika.urbandirectory.di.interfaces.ViewModelKey;
import me.erika.urbandirectory.viewmodel.SearchViewModel;

@Module
public abstract class ViewModelModule {

    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(DaggerViewModelFactory factory);

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel.class)
    abstract ViewModel provideVideoListViewModel(SearchViewModel searchViewModel);
}