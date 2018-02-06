package com.rahul.concept.interfaceInheritance;

public interface InterfaceB {
	int a=10;
	public void display(int a);
	
	public static int staticDisplayMethod(int a){
		return a*3;
	}
	
	public default int defaultDisplayMethod(int a){
		return a*3;
	}
}
