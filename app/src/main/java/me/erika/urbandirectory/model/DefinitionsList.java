package me.erika.urbandirectory.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DefinitionsList {

    @SerializedName("list")
    private List<DefinitionDO> definitions;

    public void setDefinitions(List<DefinitionDO> definitions) {
        this.definitions = definitions;
    }

    public List<DefinitionDO> getDefinitions() {
        return definitions;
    }
}
