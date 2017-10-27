package model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Histogram<T> {
    private final Map<T, Integer> mapa = new HashMap<>();

    public Integer get(T key){
        return mapa.get(key);
    }
    public Set<T> keySet(){
        return mapa.keySet();
    }
    public void increment(T key){
        if(!mapa.containsKey(key)){
            mapa.put(key, 1);
        }else{
            mapa.put(key, mapa.get(key)+1);
        }
    }    
}