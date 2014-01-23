package com.akamon.tdd.utils.reflect.powerVictor_ito;

import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * User: Victor Bolinches Marin
 * Date: 22/01/14
 * Time: 17:46
 */
public interface IPowerVictor_ito
{
	<T> T setInstanceField( Object instance,  final String fieldName, final Object newValue) throws Throwable;

	<T> T getInstanceField( Object instance,  final String fieldName ) throws Throwable;

	<T> T getInstanceMethod(Object instance, final String methoddName, final Object args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

	<T> T getInstanceMethod(Object instance, final String methoddName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;

}

