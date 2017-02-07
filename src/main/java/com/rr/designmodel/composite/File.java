package com.rr.designmodel.composite;

import java.util.List;

/**
 * Created by Limaoran on 2016/11/17.
 */
public class File implements IFile {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println(name);
    }

    @Override
    public boolean add(IFile file) {
        return false;
    }

    @Override
    public boolean remove(IFile file) {
        return false;
    }

    @Override
    public List<IFile> getChild() {
        return null;
    }
}
