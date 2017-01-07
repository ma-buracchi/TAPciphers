package it.buracchi.ciphers;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import org.junit.Test;

public class MainTest {

	@Test
	public void testMainExecution() {
		Main.main(null);
		assertEquals("a", "a");
	}
	
	@Test 
	public void testPrivateConstructor() {
		final Constructor<?>[] constructors = Main.class.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			assertTrue(Modifier.isPrivate(constructor.getModifiers()));
		}
	}

	@Test(expected = UnsupportedOperationException.class)
	public void testInstantiationConstructor() throws Exception {
		final Constructor<Main> constructor = Main.class.getDeclaredConstructor();
	    constructor.setAccessible(true);
	    try {
	        constructor.newInstance();
	    } catch (InvocationTargetException e) {
	        throw (UnsupportedOperationException) e.getTargetException();
	    }
	}

}
