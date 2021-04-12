package com.example.practicaltask;

import com.google.gson.annotations.SerializedName;

public class Entry {
    @SerializedName("im:name")
    //JsonProperty
    public ImName imName;

    public ImName getImName() {
        return imName;
    }

    public void setImName(ImName imName) {
        this.imName = imName;
    }
}
