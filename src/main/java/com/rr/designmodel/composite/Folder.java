package com.rr.designmodel.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Limaoran on 2016/11/17.
 */
public class Folder implements IFile {
    private String name;
    private List<IFile> list = null;

    public Folder(String name) {
        this.name = name;
        list = new ArrayList<>();
    }

    @Override
    public void display() {
        System.out.println(name);
    }

    @Override
    public boolean add(IFile file) {
        return list.add(file);
    }

    @Override
    public boolean remove(IFile file) {
        return list.remove(file);
    }

    @Override
    public List<IFile> getChild() {
        return list;
    }
}
