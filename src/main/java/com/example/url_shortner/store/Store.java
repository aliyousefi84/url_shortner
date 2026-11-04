package com.example.url_shortner.store;

abstract class Store {
    public Store (){};
    public abstract int storeData (String url , String value);
    public abstract String getData (String value);
}
