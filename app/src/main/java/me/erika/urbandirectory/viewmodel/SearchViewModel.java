package me.erika.urbandirectory.viewmodel;

import android.util.Log;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import me.erika.urbandirectory.model.DefinitionDO;
import me.erika.urbandirectory.model.DefinitionRepository;
import me.erika.urbandirectory.model.DefinitionsList;

/***
Description: Class in charge of handling definition search and thumbs sorting
 Author: Erika Orozco
 ***/
public class SearchViewModel extends ViewModel {

    private MutableLiveData<DefinitionsList> mDefinitionsList;
    private DefinitionsList mList = new DefinitionsList();
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

    public void sortThumbs(String sortBy){

        quickSort(mList, 0, mList.getDefinitions().size()-1, sortBy);
        mDefinitionsList.postValue(mList);
    }


    private DefinitionRepository.Callbacks mCallbacks = new DefinitionRepository.Callbacks() {
        @Override
        public void onResponse(DefinitionsList list) {
            mList = list;
            //Post value to UI with liveData
            mDefinitionsList.postValue(list);
        }

        @Override
        public void onError(String message) {
            Log.e("Test", message);
        }
    };


    private void quickSort(DefinitionsList list, int low, int high, String sortBy) {
        if (low < high) {
            int pi = partition(list.getDefinitions(), low, high, sortBy);

            quickSort(list, low, pi - 1, sortBy);
            quickSort(list, pi + 1, high, sortBy);
        }
    }

    private int partition(List<DefinitionDO> list, int low, int high, String sortBy) {
        int i = (low - 1);
        if (sortBy.equals("Thumbs Up")) {
            int pivot = list.get(high).getThumbsUp();

            for (int j = low; j < high; j++) {
                if (list.get(j).getThumbsUp() < pivot) {
                    i++;

                    DefinitionDO tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }

            DefinitionDO tmp = list.get(i + 1);
            list.set(i + 1, list.get(high));
            list.set(high, tmp);
        } else {
            int pivot = list.get(high).getThumbsDown();

            for (int j = low; j < high; j++) {
                if (list.get(j).getThumbsDown() < pivot) {
                    i++;

                    DefinitionDO tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }

            DefinitionDO tmp = list.get(i + 1);
            list.set(i + 1, list.get(high));
            list.set(high, tmp);
        }

        return i + 1;
    }
}
