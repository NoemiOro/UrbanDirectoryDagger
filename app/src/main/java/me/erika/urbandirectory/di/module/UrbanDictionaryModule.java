package me.erika.urbandirectory.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import me.erika.urbandirectory.di.interfaces.UrbanDictionaryApplicationScope;
import me.erika.urbandirectory.network.UrbanDictionaryAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class UrbanDictionaryModule {

    @UrbanDictionaryApplicationScope
    @Provides
    public UrbanDictionaryAPI urbanDictionaryAPI(Retrofit retrofit){
        return retrofit.create(UrbanDictionaryAPI.class);
    }

    @UrbanDictionaryApplicationScope
    @Provides
    public Retrofit retrofit(GsonConverterFactory gsonConverterFactory){
        return new Retrofit.Builder()
                .baseUrl("https://mashape-community-urban-dictionary.p.rapidapi.com")
                .addConverterFactory(gsonConverterFactory)
                .build();
    }

    @UrbanDictionaryApplicationScope
    @Provides
    public GsonConverterFactory gsonConverterFactory(Gson gson){
        return GsonConverterFactory.create(gson);
    }

    @UrbanDictionaryApplicationScope
    @Provides
    public Gson gson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }
}
