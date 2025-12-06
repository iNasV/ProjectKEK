package iNas.bibaProj;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
//@EnableScheduling
public class Runner {
    public static void main(String[] args) {
        SpringApplication.run(Runner.class,args);
    }

    @EventListener(ContextRefreshedEvent.class)
    public void onStartup() {
        log.info("Старт");
        System.out.println("Старт");
    }
}
