package me.erika.urbandirectory.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import me.erika.urbandirectory.R;
import me.erika.urbandirectory.viewmodel.SearchViewModel;

public class SearchFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        SearchViewModel definitions = ViewModelProviders.of(this).get(SearchViewModel.class);
        definitions.testMethod();



        return inflater.inflate(R.layout.search_fragment, container, false);

    }


}
