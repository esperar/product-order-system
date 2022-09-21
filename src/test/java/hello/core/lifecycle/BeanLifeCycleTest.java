package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {

    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleBean.class);
        NetworkClient client = ac.getBean(NetworkClient.class);
        ac.close(); //스프링 컨테이너를 종료, ConfigurableApplicationContext 필요

    }

    @Configuration
    static class LifeCycleBean {

        @Bean(initMethod = "init" , destroyMethod = "close")
        public NetworkClient networkClient(){
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("https://spring-boot.dev");
            return networkClient;
        }
    }
}
