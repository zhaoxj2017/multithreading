package com.threading;

public class MyRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("myrunnable");
		System.out.println("currentThead.name:" + Thread.currentThread().getName());
	}

}
