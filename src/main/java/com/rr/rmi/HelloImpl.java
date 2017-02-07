package com.rr.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * java rmi
 * 必须实现UnicastRemoteObject
 * Created by Limaoran on 2016/8/27.
 */
public class HelloImpl extends UnicastRemoteObject implements Hello{
    protected HelloImpl() throws RemoteException {
        super();
    }
    protected HelloImpl(int port) throws RemoteException {
        super(port);
    }

    @Override
    public String helloWorld() throws RemoteException {
        return "hello";
    }
}
