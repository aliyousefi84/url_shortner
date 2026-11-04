package com.example.url_shortner.store;

abstract class Store {
    public Store (){};
    public abstract int storeData (String url , String key);
    public abstract String getData (String key);
    public abstract int delData (String key);
    
}
