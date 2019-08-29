package me.erika.urbandirectory.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import me.erika.urbandirectory.R;
import me.erika.urbandirectory.model.DefinitionsList;
import me.erika.urbandirectory.viewmodel.SearchViewModel;

/***
 Description: Main fragment with definition search and  thumbs sorting UI
 Author: Erika Orozco
 ***/
public class SearchFragment extends Fragment implements LifecycleOwner {

    private SearchViewModel definitions;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.search_fragment, container, false);

        final String term;
        final ImageButton button = (ImageButton) v.findViewById(R.id.imageButton);

        //Set fragment as life cycle owner
        definitions = ViewModelProviders.of(this).get(SearchViewModel.class);
        if (savedInstanceState == null) {
            definitions.init();
        }



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // term = .getText();

                //Make DefinitionsList observable to refresh every time term changes
                // Let the view model know something happened.
                definitions.getDefinition("strawberry")
                        .observe(SearchFragment.this, new Observer<DefinitionsList>() {
                            @Override
                            public void onChanged(DefinitionsList definitionsList) {
                                Log.v("LiveDataAndy", definitionsList.toString());
                            }
                        });
            }
        });


        return v;

    }


}
