package hello.core.beanfind;

import hello.core.Appconfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

 class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Appconfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beaanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beaanDefinitionName : beaanDefinitionNames) {
            Object bean = ac.getBean(beaanDefinitionName);
            System.out.println("name = " + beaanDefinitionName+ " object="+ bean );
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicaionBean() {
        String[] beaanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beaanDefinitionName : beaanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beaanDefinitionName);

            //Role ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
            //Role ROLE_INFRASTRUCTURE: 스프링이 내부에서 관리하는 빈
            //애플리케이션 개발위해 등록한 빈들
            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beaanDefinitionName);
                System.out.println("name = " + beaanDefinitionName+ " object="+ bean );
            }
        }


    }
}
