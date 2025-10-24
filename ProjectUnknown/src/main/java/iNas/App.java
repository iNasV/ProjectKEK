package iNas;

import iNas.responses.BibaResponse;
import iNas.responses.BobaResponse;
import iNas.bibaProj.service.BibaService;
import iNas.bibaProj.service.BobaService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@AllArgsConstructor
public class App {
    private final BibaService bibaService;
    private final BobaService bobaService;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @EventListener(ContextRefreshedEvent.class)
    public void onStartup() {
        BibaResponse bibaResponses = bibaService.shouldBibaServer().getFirst();
        BobaResponse bobaResponses = bobaService.shouldBobaServer().getFirst();
        System.out.println(bibaResponses.getId());
        System.out.println(bobaResponses.getName());



    }
}
