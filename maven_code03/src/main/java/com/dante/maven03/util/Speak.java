package com.dante.maven03.util;
import com.dante.maven01.model.HelloWorld;

public class Speak{
	public String sayHi(){
		return new HelloWorld().sayHello();
	}
}

