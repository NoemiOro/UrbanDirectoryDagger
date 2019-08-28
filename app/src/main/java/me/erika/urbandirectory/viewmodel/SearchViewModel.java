package me.erika.urbandirectory.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;
import me.erika.urbandirectory.model.DefinitionRepository;
import me.erika.urbandirectory.model.DefinitionsList;

public class SearchViewModel extends ViewModel {

    private DefinitionRepository repo = new DefinitionRepository();
    private DefinitionRepository.Callbacks mCallbacks = new DefinitionRepository.Callbacks() {
        @Override
        public void onResponse(DefinitionsList list) {
            Log.v("Test","liset" + list);
        }

        @Override
        public void onError(String message) {
            Log.e("Test", message);
        }
    };

    public void testMethod(){
        repo.setCallbacks(mCallbacks);
        repo.loadData("apple");
    }

}
