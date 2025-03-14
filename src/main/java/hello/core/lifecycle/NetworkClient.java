package hello.core.lifecycle;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class NetworkClient{

    private String url;

    public NetworkClient(){
        System.out.println("생성자 호출, url = " + url);
        //connect();
        //call("초기화 연결 메시지");
    }

    public void setUrl(String url){
        this.url = url;
    }

    // 서비스 시작시 호출
    public void connect(){
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call: " + url + "message = " + message);
    }

    // 서비스 종료시 호출
    public void disconnect(){
        System.out.println("close : " + url);
    }

    @PostConstruct
    public void init(){
        System.out.println("NetworkClient.init");
        connect();
        call("초기화 연결 메시지");
    }

    @PreDestroy
    public void close(){
        System.out.println("NetworkClient.close");
        disconnect();
    }

    // 빈 등록 초기화, 소멸 메서드 지정
    //public void init(){
    //    System.out.println("NetworkClient.init");
    //    connect();
    //    call("초기화 연결 메시지");
    //}

    //public void close(){
    //   System.out.println("NetworkClient.close");
    //   disconnect();
    //}

    // 의존관계 주입이 끝나면 호출해 주겠다.(afterPropertiesSet)
    // 인터페이스 InitializingBean, DisposableBean
    //@Override
    //public void afterPropertiesSet() throws Exception{
    //    connect();
    //    call("초기화 연결 메시지");
    //}

    //@Override
    //public void destroy() throws Exception{
    //    disconnect();
    //}
}
