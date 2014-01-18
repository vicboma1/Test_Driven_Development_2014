package com.akamon.tdd.auth.api.internal;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 18/01/14
 * Time: 10:42
 * To change this template use File | Settings | File Templates.
 */
public interface IInternal
{
	String getPassword();
	boolean authentication()  throws InterruptedException;
}
