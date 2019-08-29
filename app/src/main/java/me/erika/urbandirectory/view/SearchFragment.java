package me.erika.urbandirectory.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import me.erika.urbandirectory.R;
import me.erika.urbandirectory.model.DefinitionsList;
import me.erika.urbandirectory.viewmodel.SearchViewModel;

/***
 Description: Main fragment with definition search and  thumbs sorting UI
 Author: Erika Orozco
 ***/
public class SearchFragment extends Fragment implements LifecycleOwner {

    private SearchViewModel definitions;
    private EditText mTermEditText;
    private ImageButton mSearchButton;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private DefinitionsAdapter mDefinitionsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.search_fragment, container, false);

        mTermEditText = v.findViewById(R.id.termEditText);
        mSearchButton = v.findViewById(R.id.imageButton);
        mProgressBar = v.findViewById(R.id.progressBar);
        mRecyclerView = v.findViewById(R.id.recyclerView);

        //Set fragment as life cycle owner
        definitions = ViewModelProviders.of(this).get(SearchViewModel.class);

        if (savedInstanceState == null) {
            definitions.init();
        }

        mSearchButton.setOnClickListener(mOnClickListener);
        mDefinitionsAdapter = new DefinitionsAdapter();
        mRecyclerView.setAdapter(mDefinitionsAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) );

        return v;

    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String term = mTermEditText.getText().toString();
            mProgressBar.setVisibility(View.VISIBLE);
            //Make DefinitionsList observable to refresh every time term changes
            // Let the view model know something happened.
            definitions.getDefinition(term)
                    .observe(SearchFragment.this, new Observer<DefinitionsList>() {
                        @Override
                        public void onChanged(DefinitionsList definitionsList) {
                            Log.v("LiveDataAndy", definitionsList.toString());
                            mProgressBar.setVisibility(View.GONE);
                            mDefinitionsAdapter.setDefinitions(definitionsList.getDefinitions());
                        }
                    });
        }
    };


}
