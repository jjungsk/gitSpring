package hello_di.com.ssafy.hello.di4;

public class HelloMessageKor implements HelloMessage {
	
	public HelloMessageKor() {
		System.out.println("HelloMessageKor 객체 생성 시작");
	}

	
	@Override
	public String hello(String name) {
		
		return "안녕 " + name;
	}

}
