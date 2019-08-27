package me.erika.urbandirectory.network;

import java.util.List;

import me.erika.urbandirectory.model.DefinitionDO;
import me.erika.urbandirectory.model.DefinitionsList;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

//Urban Dictionary API Endpoint
public interface UrbanDictionaryAPI {

    //key and  host are the headers required by the API
    @Headers({
            "X-RapidAPI-Host: mashape-community-urban-dictionary.p.rapidapi.com",
            "X-RapidAPI-Key: c977c7c52amsh02ac9404b58b8c4p1ea727jsn8582dbbc0df2"
    })
    //define is the endpoint given by the API
    @GET("/define")
    //term is the query parameter required by the API
    Call<DefinitionsList> listDefinitions(@Query("term") String term);

}
