package com.threading;

public class MyThread extends Thread{
	public MyThread(){
		
	}
	
	public MyThread(String threadName){
		setName(threadName);
	}
	
	public void run(){
		System.out.println("mythread");
		System.out.println("currentThead.name:" + getName());
	}
}
