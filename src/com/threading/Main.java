package com.threading;

public class Main {
	public static void main(String[] args){
		startRunnable();
		startThread();
	}
	
	
	private static void startRunnable(){
		MyRunnable myRunnable = new MyRunnable();
		Thread thread = new Thread(myRunnable, "MyRunnable-0");
		thread.start();
		System.out.println("myrunnable.name:" + thread.getName());
	}
	
	
	/**
	 * 	继承Thread
	 * 	此方式给线程命名的方式可以给子类添加构造器，然后setName。
	 * 	另外一种方式通过New Thread，包装子类。
	 * 	在命名线程名上，会比实现runnable的方式要复杂一点。
	 */
	private static void startThread(){
		MyThread mythread = new MyThread();
/*		
 * 		用此方式给线程命名
 * 		Thread thread2 = new Thread(mythread, "MyThread-0");
		thread2.start();
		System.out.println("mythread.getName:" + thread2.getName());
*/
		mythread.start();
		System.out.println("mythread.name:" + mythread.getName());
	}
}
