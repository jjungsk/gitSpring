package hello_di.com.ssafy.hello.di2;

public class HelloMain {
	
	public static void main(String[] args) {
//		HelloMessage helloMessage = new HelloMessageKor();
//		System.out.println(helloMessage.hello("정세권"));
		
		HelloMessageEng helloMessage = new HelloMessageEng();
		System.out.println(helloMessage.hello("TBO"));
	}

}
