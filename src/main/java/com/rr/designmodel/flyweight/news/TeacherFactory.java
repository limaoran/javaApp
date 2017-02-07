package com.rr.designmodel.flyweight.news;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Limaoran on 2016/11/17.
 */
public class TeacherFactory {
    private Map<String,Teacher> pool;
    public TeacherFactory(){
        pool = new HashMap<>();
    }
    public Teacher getTeacher(String number){
        Teacher teacher = pool.get(number);
        if(teacher==null){
            teacher = new Teacher();
            teacher.setNumber(number);
            pool.put(number,teacher);
        }
        return teacher;
    }
}
