package com.mkyong.rest;

public class Main {
public static void main(String[] args){
	StringBuffer buffer= new StringBuffer();
	
	
	buffer.append("muthu").append("raj");
	System.out.println(buffer.toString());
	buffer.append("S");
	System.out.println(buffer.toString());
	
	boolean active=false;
	
	buffer.append(active);
	System.out.println(buffer.toString());
}
}
