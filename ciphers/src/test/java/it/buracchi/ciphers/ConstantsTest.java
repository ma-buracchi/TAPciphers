package it.buracchi.ciphers;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class ConstantsTest {

	@Test 
	public void testPrivateConstructor() {
		final Constructor<?>[] constructors = Constants.class.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			assertTrue(Modifier.isPrivate(constructor.getModifiers()));
		}
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testInstantiationConstructor() throws Exception {
		final Constructor<Constants> constructor = Constants.class.getDeclaredConstructor();
	    constructor.setAccessible(true);
	    try {
	        constructor.newInstance();
	    } catch (InvocationTargetException e) {
	        throw (UnsupportedOperationException) e.getTargetException();
	    }
	}

}
