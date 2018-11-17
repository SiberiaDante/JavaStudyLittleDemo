package com.dante.maven03.util;
import org.junit.*;
import org.junit.Assert.*;
public class SpeakTest(){
	@Test
	public void testSayHi(){
		Assert.assertEquals("HelloWorld",new Speak().sayHi());
	}
}

