package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    @DisplayName("싱글톤 객체 테스트 error")
    void statefulServiceSingletonError() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // a가 1000원 주문
        statefulService1.order("userA", 1000);
        // a가 1000원 주문
        statefulService2.order("userB", 2000);

//        // ThreadA: 사용자 A가 주문 금액 조회
//        int price = statefulService1.getPrice();
//        System.out.println("price = " + price);
//
//        // 하나의 객체를 공유하는 싱글톤 특성상 userB가 앞전의 userA의 주문을 덮어버림, stateful하지 못한 상태
//        Assertions.assertThat(statefulService1.getPrice()).isEqualTo(1000);
    }

    @Test
    @DisplayName("싱글톤 객체 테스트 successful")
    void statefulServiceSingletonResolve() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // a가 1000원 주문
        int userA = statefulService1.order("userA", 1000);
        // a가 1000원 주문
        int userB = statefulService2.order("userB", 2000);

        // ThreadA: 사용자 A가 주문 금액 조회
        System.out.println("price = " + userA);

        Assertions.assertThat(userA).isEqualTo(1000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }

    }

}