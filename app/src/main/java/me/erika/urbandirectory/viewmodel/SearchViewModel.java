package me.erika.urbandirectory.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import me.erika.urbandirectory.model.DefinitionRepository;
import me.erika.urbandirectory.model.DefinitionsList;

/***
Description: Class in charge of handling definition search and thumbs sorting
 Author: Erika Orozco
 ***/
public class SearchViewModel extends ViewModel {

    private MutableLiveData<DefinitionsList> mDefinitionsList;
    private DefinitionRepository repo = new DefinitionRepository();

    //Retrieving info from repository
    public LiveData<DefinitionsList> getDefinition(String term){
        //If it is the first time
        if(mDefinitionsList==null){
            mDefinitionsList = new MutableLiveData<>();
            repo.setCallbacks(mCallbacks);
            repo.loadData(term);
        }

        return mDefinitionsList;
    }

    private DefinitionRepository.Callbacks mCallbacks = new DefinitionRepository.Callbacks() {
        @Override
        public void onResponse(DefinitionsList list) {
            Log.v("Test","liset" + list);
            //Post value to UI with liveData
            mDefinitionsList.postValue(list);
        }

        @Override
        public void onError(String message) {
            Log.e("Test", message);
        }
    };
}
