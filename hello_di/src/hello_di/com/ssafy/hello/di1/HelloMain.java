package hello_di.com.ssafy.hello.di1;

public class HelloMain {
	
	public static void main(String[] args) {
		HelloMessageKor kor = new HelloMessageKor();
		System.out.println(kor.helloKor("정세권"));
		
		HelloMessageEng eng = new HelloMessageEng();
		System.out.println(eng.helloEng("TBO"));
	}

}
