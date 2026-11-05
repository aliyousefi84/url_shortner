package com.example.url_shortner.schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SetKey {

    public SetKey (){}

    @JsonProperty ("url")
    String url;
    
    @JsonProperty ("key")
    String key;

    //int time;

    public void SetUrl (String url) {this.url = url;}
    public void SetKeyName (String key) {this.key = key;}
    //public void SetTime (int time) {this.time = time;}

    public String GetUrl () {return this.url;}
    public String GetKey () {return this.key;}
    //public int GetTime () {return this.time;}

}
