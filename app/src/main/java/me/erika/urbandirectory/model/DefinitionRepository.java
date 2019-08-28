package me.erika.urbandirectory.model;

import android.util.Log;

import me.erika.urbandirectory.network.UrbanDictionaryAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DefinitionRepository {

    private Callbacks mCallbacks;

    public void loadData(String term) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mashape-community-urban-dictionary.p.rapidapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UrbanDictionaryAPI service = retrofit.create(UrbanDictionaryAPI.class);

        Call<DefinitionsList> definitions = service.listDefinitions(term);


        definitions.enqueue(new Callback<DefinitionsList>() {
            @Override
            public void onResponse(Call<DefinitionsList> call, Response<DefinitionsList> response) {

                mCallbacks.onResponse(response.body());
            }

            @Override
            public void onFailure(Call<DefinitionsList> call, Throwable t) {
                Log.e("Definition", t.getMessage());
            }
        });
    }

    public void setCallbacks(Callbacks callbacks) {
        mCallbacks = callbacks;
    }

    public interface Callbacks{
         void onResponse(DefinitionsList list);
         void onError(String message);
    }
}

