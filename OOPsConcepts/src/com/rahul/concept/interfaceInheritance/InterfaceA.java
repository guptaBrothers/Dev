package com.rahul.concept.interfaceInheritance;

 // private  interface A {   // Illegal modifier for the interface A; only public & abstract are permitted
// interface A {   // default access modifier is public

public interface InterfaceA {	
 	// int a;               // "The blank final field a may not have been initialized"  - interfaces can have only constant fields 
	int  a = 10;        // By default constant field
	
	// private void print();                "Illegal modifier for the interface method print; only public, abstract, default, static and strictfp are permitted"
	public  void display(int a);
	
	/*
	 * abstract static int  staticDisplay(int a){
	 * Illegal combination of modifiers for the interface method staticDisplay; only one of abstract, default, or static permitted
	 * */
	public static int  staticDisplayMethod(int a){
		return a*2;
	}
	
	default int defaultDisplayMethod(int a){
		return a*2;
	}
}
