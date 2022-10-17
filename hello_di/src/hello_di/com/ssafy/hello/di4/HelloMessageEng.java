package hello_di.com.ssafy.hello.di4;

public class HelloMessageEng implements HelloMessage {
	
	public HelloMessageEng() {
		System.out.println("HelloMessageEng 객체 생성 시작");
		
	}
	
	public void init() {
		System.out.println("Eng 객체 초기화");
	}

	@Override
	public String hello(String name) {
		
		return "hello " + name;
	}

}
