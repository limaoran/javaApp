package com.rr.log;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.Serializable;

/**
 * Created by Limaoran on 2016/9/27.
 */
public class LogPrint implements Serializable{
    private static final long serialVersionUID = 8033811456249864050L;
    private transient Log log = null;

    /**
     * 构造函数，带调用类名
     * @param className
     */
    public LogPrint(final String className){
        log = LogFactory.getLog(className);
    }

    /**
     * 构造函数，带调用类参数构造
     * @param c
     */
    public LogPrint(Class c){
        log = LogFactory.getLog(c);
    }

    /**
     * 判断是否可以输出DEBUG级别的调试信息。
     * @return 若可以输出DEBUG级别的调试信息，返回true；否则返回false。
     */
    public boolean isDebugEnabled(){
        return log.isDebugEnabled();
    }
    /**
     * 判断是否可以输出INFO级别的调试信息。
     * @return  若可以输出INFO级别的调试信息，返回true；否则返回false。
     */
    public boolean isInfoEnabled() {
        return log.isInfoEnabled();
    }
    /**
     * 判断是否可以输出WARN级别的调试信息。
     * @return   若可以输出WARN级别的调试信息，返回true；否则返回false。
     */
    public boolean isWarnEnabled() {
        return log.isWarnEnabled();
    }
    /**
     * 判断是否可以输出ERROR级别的调试信息。
     * @return   若可以输出ERROR级别的调试信息，返回true；否则返回false。
     */
    public boolean isErrorEnabled() {
        return log.isErrorEnabled();
    }
    /**
     * 判断是否可以输出FATAL级别的调试信息。
     * @return   若可以输出FATAL级别的调试信息，返回true；否则返回false。
     */
    public boolean isFatalEnabled() {
        return log.isFatalEnabled();
    }
    /**
     * 判断是否可以输出TRACE级别的调试信息。
     * @return   若可以输出TRACE级别的调试信息，返回true；否则返回false。
     */
    public boolean isTraceEnabled() {
        return log.isTraceEnabled();
    }
    /**
     * 输出TRACE级别的调试信息.
     * @param message  调试信息参数。若调用该接口，且传入参数为异常对象，则仅打印异常信息（调用异常对象的toString()方法），而不打印异常堆栈信息。
     */
    public void trace(Object message){
        log.trace(message);
    }
    /**
     * 输出TRACE级别的调试信息.
     * @param message 调试信息参数
     * @param t 异常对象参数。将打印该异常对象堆栈信息
     */
    public void trace(Object message,Throwable t){
        log.trace(message,t);
    }
    /**
     * 输出DEBUG级别的调试信息.
     * @param message  调试信息参数。若调用该接口，且传入参数为异常对象，则仅打印异常信息（调用异常对象的toString()方法），而不打印异常堆栈信息。
     */
    public void debug(Object message){
        log.debug(message);
    }
    /**
     * 输出DEBUG级别的调试信息.
     * @param message 调试信息参数
     * @param t 异常对象参数。将打印该异常对象堆栈信息
     */
    public void debug(Object message,Throwable t){
        log.debug(message,t);
    }
    /**
     * 输出INFO级别的调试信息.
     * @param message  调试信息参数。若调用该接口，且传入参数为异常对象，则仅打印异常信息（调用异常对象的toString()方法），而不打印异常堆栈信息。
     */
    public void info(Object message){
        log.info(message);
    }
    /**
     * 输出INFO级别的调试信息.
     * @param message 调试信息参数
     * @param t 异常对象参数。将打印该异常对象堆栈信息
     */
    public void info(Object message,Throwable t){
        log.info(message,t);
    }
    /**
     * 输出WARN级别的调试信息.
     * @param message  调试信息参数。若调用该接口，且传入参数为异常对象，则仅打印异常信息（调用异常对象的toString()方法），而不打印异常堆栈信息。
     */
    public void warn(Object message){
        log.warn(message);
    }
    /**
     * 输出WARN级别的调试信息.
     * @param message 调试信息参数
     * @param t 异常对象参数。将打印该异常对象堆栈信息
     */
    public void warn(Object message,Throwable t){
        log.warn(message,t);
    }
    /**
     * 输出FATAL级别的调试信息.
     * @param message  调试信息参数。若调用该接口，且传入参数为异常对象，则仅打印异常信息（调用异常对象的toString()方法），而不打印异常堆栈信息。
     */
    public void fatal(Object message){
        log.fatal(message);
    }
    /**
     * 输出FATAL级别的调试信息.
     * @param message 调试信息参数
     * @param t 异常对象参数。将打印该异常对象堆栈信息
     */
    public void fatal(Object message,Throwable t){
        log.fatal(message,t);
    }
    /**
     * 输出ERROR级别的调试信息.
     * @param message  调试信息参数。若调用该接口，且传入参数为异常对象，则仅打印异常信息（调用异常对象的toString()方法），而不打印异常堆栈信息。
     */
    public void error(Object message){
        log.error(message);
    }
    /**
     * 输出ERROR级别的调试信息.
     * @param message 调试信息参数
     * @param t 异常对象参数。将打印该异常对象堆栈信息
     */
    public void error(Object message,Throwable t){
        log.error(message,t);
    }
}
