package me.erika.urbandirectory;

import androidx.appcompat.app.AppCompatActivity;
import me.erika.urbandirectory.model.DefinitionDO;
import me.erika.urbandirectory.model.DefinitionsList;
import me.erika.urbandirectory.network.UrbanDictionaryAPI;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://mashape-community-urban-dictionary.p.rapidapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UrbanDictionaryAPI service = retrofit.create(UrbanDictionaryAPI.class);

        Call<DefinitionsList> definitions = service.listDefinitions("apple");

        definitions.enqueue(new Callback<DefinitionsList>() {
            @Override
            public void onResponse(Call<DefinitionsList> call, Response<DefinitionsList> response) {

                Log.v("Definition", response.body().toString());
            }

            @Override
            public void onFailure(Call<DefinitionsList> call, Throwable t) {
                Log.e("Definition", t.getMessage());
            }
        });
    }
}
