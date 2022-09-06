package hello.core.singleton;

public class SingletonService {

    //1. static 영역에 딱 1개의 객체만 생성된다.
    private static final SingletonService instance = new SingletonService();

    //2. public 으로 열어서 객체 인스터스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 3. 생성자를 private 로 생성해서 외부에서 객체 생성을 막는다.
    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 호출");
    }

}
