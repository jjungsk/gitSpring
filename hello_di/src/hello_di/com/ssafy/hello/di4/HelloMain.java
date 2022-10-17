package hello_di.com.ssafy.hello.di4;

import javax.naming.Context;

import org.omg.CORBA.portable.ApplicationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {
	
	public static void main(String[] args) {
		
		System.out.println("프로그램 시작");
		
		// xml 읽어라
		ApplicationContext context = new ClassPathXmlApplicationContext("/hello_di/com/ssafy/hello/di4/applicationContext.xml");
		System.out.println("xml 읽기 끝");
		
		HelloMessage hello = (HelloMessage) context.getBean("kor"); // 이름으로 설정 시 
		String greet = hello.hello("정세권");
		System.out.println(greet);
		
		HelloMessage hello2 = (HelloMessage) context.getBean("eng");
		
		HelloMessage hello3 = (HelloMessage) context.getBean("eng");
		System.out.println(hello + " " + hello2 + " " + hello3);
		
	}

}
