package me.erika.urbandirectory.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;

import java.util.ArrayList;

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
    private Spinner mSpinner;
    private DefinitionsAdapter mDefinitionsAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.search_fragment, container, false);

        mTermEditText = v.findViewById(R.id.termEditText);
        mSearchButton = v.findViewById(R.id.imageButton);
        mProgressBar = v.findViewById(R.id.progressBar);
        mRecyclerView = v.findViewById(R.id.recyclerView);
        mSpinner = v.findViewById(R.id.spinner);


        //Reference to viewModel
        definitions = ViewModelProviders.of(this).get(SearchViewModel.class);


        if (savedInstanceState == null) {
            definitions.init();
        }

        //Call observer to load definitions, this should be after mDefinitionsList is initialized
        definitions.loadDefinitions().observe(SearchFragment.this, mObserver);


        mSearchButton.setOnClickListener(mOnClickListener);
        mDefinitionsAdapter = new DefinitionsAdapter();
        mRecyclerView.setAdapter(mDefinitionsAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false) );

        setUpSpinner();

        return v;

    }

    //Observe list with live data
    private Observer mObserver = new Observer<DefinitionsList>() {
        @Override
        public void onChanged(DefinitionsList definitionsList) {
            mProgressBar.setVisibility(View.GONE);
            mDefinitionsAdapter.setDefinitions(definitionsList.getDefinitions());
        }
    };

    //Load search from value inserted
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String term = mTermEditText.getText().toString();
            mProgressBar.setVisibility(View.VISIBLE);
            //Make DefinitionsList observable to refresh every time term changes
            // Let the view model know something happened.
           definitions.getDefinition(term).observe(SearchFragment.this,mObserver);
        }
    };


    private void setUpSpinner(){

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(getResources().getString(R.string.spinner_thumbs_up));
        arrayList.add(getResources().getString(R.string.spinner_thumbs_down));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(arrayAdapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String sortBy = parent.getItemAtPosition(position).toString();
                definitions.sortThumbs(sortBy);
            }
            @Override
            public void onNothingSelected(AdapterView <?> parent) {
            }
        });
    }
}
