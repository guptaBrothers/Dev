package com.rahul.concept.interfaceInheritance;

/*Duplicate default methods named defaultDisplayMethod with 
 * the parameters (int) and (int) are inherited from the types InterfaceB and InterfaceA
 */

public class CheckDimondInInterface implements InterfaceA, InterfaceB {

	@Override
	public void display(int a) {
		// TODO Auto-generated method stub
		System.out.println(a);
	}
	
	// public default Long defaultDisplayMethod(int a){
	// The return type is incompatible with InterfaceB.defaultDisplayMethod(int) - method signature + return type "must" be same 
	
	@Override
	public int defaultDisplayMethod(int a) {
		// TODO Auto-generated method stub
		return InterfaceA.super.defaultDisplayMethod(a);
	}


	public static void main(String[] args) {
		CheckDimondInInterface obj = new CheckDimondInInterface();
		obj.defaultDisplayMethod(10);
		
		obj.display(10);
		
		InterfaceA.staticDisplayMethod(10);
		InterfaceB.staticDisplayMethod(10);
	}

}
