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
	 * 	�̳�Thread
	 * 	�˷�ʽ���߳������ķ�ʽ���Ը�������ӹ�������Ȼ��setName��
	 * 	����һ�ַ�ʽͨ��New Thread����װ���ࡣ
	 * 	�������߳����ϣ����ʵ��runnable�ķ�ʽҪ����һ�㡣
	 */
	private static void startThread(){
		MyThread mythread = new MyThread();
/*		
 * 		�ô˷�ʽ���߳�����
 * 		Thread thread2 = new Thread(mythread, "MyThread-0");
		thread2.start();
		System.out.println("mythread.getName:" + thread2.getName());
*/
		mythread.start();
		System.out.println("mythread.name:" + mythread.getName());
	}
}
