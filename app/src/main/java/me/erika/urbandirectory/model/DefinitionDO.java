package me.erika.urbandirectory.model;

import com.google.gson.annotations.SerializedName;

/***
 Description: POJO to keep definitions retrieved by  service.
 Author: Erika Orozco
 ***/
public class DefinitionDO {

    private String definition;

    @SerializedName("thumbs_up")
    private int thumbsUp;

    @SerializedName("thumbs_down")
    private int thumbsDown;


//    {
//        "definition": "THE MOST BADASS FUCKING FRUIT ON THE FUCKING PLANET. SERIOUSLY, THIS MOTHERFUCKER KICKS THE SHIT OUT OF THE PUSSY ORANGE OR BANANA. THIS JUICY, RED MOTHERFUCKER IS THE BEST [FUCKING THING] THAT GOD HAS EVER CREATED. EAT AN [A APPLE] AND YOUR DICK WILL GROW [3 INCHES]. FUCK.",
//            "permalink": "http://apple.urbanup.com/5486633",
//            "thumbs_up": 9002,
//            "author": "beaverbounce",
//            "word": "apple",
//            "defid": 5486633,
//            "current_vote": "",
//            "written_on": "2011-01-04T00:00:00.000Z",
//            "example": "[Woah], look at that [badass] over there eating [an apple]",
//            "thumbs_down": 1037
//    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getThumbsUp() {
        return thumbsUp;
    }

    public void setThumbsUp(int thumbsUp) {
        this.thumbsUp = thumbsUp;
    }

    public int getThumbsDown() {
        return thumbsDown;
    }

    public void setThumbsDown(int thumbsDown) {
        this.thumbsDown = thumbsDown;
    }
}
