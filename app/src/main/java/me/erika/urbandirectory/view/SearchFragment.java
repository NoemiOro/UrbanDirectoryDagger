package me.erika.urbandirectory.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import me.erika.urbandirectory.R;
import me.erika.urbandirectory.model.DefinitionsList;
import me.erika.urbandirectory.viewmodel.SearchViewModel;

public class SearchFragment extends Fragment implements LifecycleOwner {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        SearchViewModel definitions = ViewModelProviders.of(this).get(SearchViewModel.class);
        definitions.getDefinition("strawberry").observe(this, new Observer<DefinitionsList>() {
            @Override
            public void onChanged(DefinitionsList definitionsList) {
                Log.v("LiveDataAndy", definitionsList.toString());
            }
        });


        return inflater.inflate(R.layout.search_fragment, container, false);

    }


}
