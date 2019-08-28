package me.erika.urbandirectory.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import me.erika.urbandirectory.model.DefinitionRepository;
import me.erika.urbandirectory.model.DefinitionsList;


public class SearchViewModel extends ViewModel {

    private MutableLiveData<DefinitionsList> mDefinitionsList;

    public LiveData<DefinitionsList> getDefinition(String term){
        if(mDefinitionsList==null){
            mDefinitionsList = new MutableLiveData<>();
            repo.setCallbacks(mCallbacks);
            repo.loadData(term);
        }

        return mDefinitionsList;
    }

    private DefinitionRepository repo = new DefinitionRepository();
    private DefinitionRepository.Callbacks mCallbacks = new DefinitionRepository.Callbacks() {
        @Override
        public void onResponse(DefinitionsList list) {
            Log.v("Test","liset" + list);
            mDefinitionsList.postValue(list);
        }

        @Override
        public void onError(String message) {
            Log.e("Test", message);
        }
    };
}
