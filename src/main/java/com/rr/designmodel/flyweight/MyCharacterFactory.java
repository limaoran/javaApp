package com.rr.designmodel.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Limaoran on 2016/11/17.
 */
public class MyCharacterFactory {
    private Map<Character,MyCharacter> pool;
    public MyCharacterFactory() {
        pool = new HashMap<Character,MyCharacter>();
    }
    public MyCharacter getMyCharacter(Character character){
        MyCharacter mychar = pool.get(character);
        if(mychar==null){
            mychar = new MyCharacter(character);
            pool.put(character,mychar);
        }
        return mychar;
    }
}
