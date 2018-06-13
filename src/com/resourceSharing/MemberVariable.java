package com.resourceSharing;


/**
 * �����Ա����ʱ������
 * ����ִ�к�Ľ��������ģ���ʱ��ᱨ�����ִ�е���˳��������ġ�
 * @author ���˾�_F
 * ���̹߳����Ա������ʱ�����̲߳���ȫ�ġ�
 * StringBuilder�ĵ�������������еĶ�����˶���̲߳�������ͬһ����������ݡ�
 * String�ĵ����Ǽ򵥵ĸ�ֵ����ֵ�����һ���̵߳ĸ�ֵ���Ϊ׼��
 * Java�����ǰ�ֵ���ݡ�Java���ݵ���Զ��ֵ��
 * 		1���������ͣ�����--> ֵ
 * 		2�����ö����ַ��������� -->��ַ-->���ж���
 * 		1��2��ǰ�����Ǵ洢��ջ�С�
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