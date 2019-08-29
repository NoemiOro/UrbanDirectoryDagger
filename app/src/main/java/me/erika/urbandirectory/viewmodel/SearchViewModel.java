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
    private DefinitionRepository repo;

    //One time initialization
    public void init(){
        repo = new DefinitionRepository();
        repo.setCallbacks(mCallbacks);
        mDefinitionsList = new MutableLiveData<>();

    }

    //Retrieving definitions from repository
    public LiveData<DefinitionsList> getDefinition(String term){

        repo.loadData(term);

        return mDefinitionsList;
    }

    public void sortThumps(){

    }

    private DefinitionRepository.Callbacks mCallbacks = new DefinitionRepository.Callbacks() {
        @Override
        public void onResponse(DefinitionsList list) {
            Log.v("Test","list" + list);
            //Post value to UI with liveData
            mDefinitionsList.postValue(list);
        }

        @Override
        public void onError(String message) {
            Log.e("Test", message);
        }
    };
}
