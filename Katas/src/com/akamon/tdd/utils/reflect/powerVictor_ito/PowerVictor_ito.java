package com.akamon.tdd.utils.reflect.powerVictor_ito;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: vicboma
 * Date: 22/01/14
 * Time: 17:46
 */
public class PowerVictor_ito
{
	public <T> T setInstanceField( Object instance,  final String fieldName, final Object newValue) throws Throwable
	{
		final Field field = getField(instance, fieldName);
		activateReadPrivateAccess(field);
		field.set(instance,newValue);

		return getResult(instance, field);
	}

	public <T> T getInstanceField( Object instance, final String fieldName ) throws Throwable
	{
		final Field field = getField(instance, fieldName);
		activateReadPrivateAccess(field);

		return getResult(instance, field);
	}

	public <T> T getInstanceMethod(Object instance, final String methoddName) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException
	{
		final Method method = instance.getClass().getDeclaredMethod(methoddName,null);
		method.setAccessible(true);

		return (T) method.invoke(instance, null);
	}

	private <T> T getResult(Object instance, Field field) throws IllegalAccessException
	{
		return (T)field.get(instance);
	}

	private Field getField(Object instance, String fieldName) throws NoSuchFieldException
	{
		return instance.getClass().getDeclaredField(fieldName);
	}


	private void activateReadPrivateAccess(Field field)
	{
		field.setAccessible(true);
	}
}
