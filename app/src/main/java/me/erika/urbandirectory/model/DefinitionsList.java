package me.erika.urbandirectory.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/***
 Description: Class to access the list within DefinitionDO
 Author: Erika Orozco
 ***/
public class DefinitionsList {

    @SerializedName("list")
    private List<DefinitionDO> definitions = new ArrayList<>();

    public void setDefinitions(List<DefinitionDO> definitions) {
        this.definitions = definitions;
    }

    public List<DefinitionDO> getDefinitions() {
        return definitions;
    }
}
