package com.rr.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * java rmi
 * 必须实现Remote接口
 * Created by Limaoran on 2016/8/27.
 */
public interface Hello extends Remote {
    String helloWorld() throws RemoteException;
}
