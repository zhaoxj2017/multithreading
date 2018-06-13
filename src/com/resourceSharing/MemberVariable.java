package com.resourceSharing;


/**
 * 共享成员变量时的问题
 * 此类执行后的结果是随机的，有时候会报错。因此执行的流顺序是随机的。
 * @author 赵兴君_F
 * 多线程共享成员变量的时候，是线程不安全的。
 * StringBuilder的调用是引用其堆中的对象，因此多个线程操作的是同一个对象的数据。
 * String的调用是简单的赋值，其值由最后一个线程的赋值结果为准。
 * Java仅仅是按值传递。Java传递的永远是值。
 * 		1、基本类型：变量--> 值
 * 		2、引用对象，字符串和数组 -->地址-->堆中对象
 * 		1和2的前两项是存储在栈中。
 *
 */
class MemberVariable {
	public static void main(String[] args){
		SharedInstance instance = new SharedInstance();
		new Thread(new MyRunnable(instance),"threadA").start();
		new Thread(new MyRunnable(instance),"threadB").start();
	}
}

class SharedInstance{
	StringBuilder builder = new StringBuilder();
	String str = new String();
	
	public void add(String text){
		this.builder.append(text);
	}
	
	public void chance(String str){
		this.str = str;
	}
}


class MyRunnable implements Runnable{
	SharedInstance instance;
	
	public MyRunnable(SharedInstance instance){
		this.instance = instance;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		instance.add("something ");
		instance.chance("some change");
		System.out.println("Member Varables(Reference thansfer): " + instance.builder);
		System.out.println("Member Varables(value thansfer): " + instance.str);
	}
	
}