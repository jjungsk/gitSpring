package hello_di.com.ssafy.hello.di3;

public class HelloMain {
	
	public static void main(String[] args) {
		
		HelloMessage hello = HelloMessageFactory.getHelloMessage("eng");
		System.out.println(hello.hello("TBO"));
	}

}
