package iNas;

import iNas.unknownProj.feign.BibaClient;
import iNas.unknownProj.feign.BobaClient;
import iNas.unknownProj.responses.BibaResponse;
import iNas.unknownProj.responses.BobaResponse;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableFeignClients
@AllArgsConstructor
public class App {
    private final BibaClient bibaClient;
    private final BobaClient bobaClient;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @EventListener(ContextRefreshedEvent.class)
    public void onStartup() {
        BibaResponse bibaResponses = bibaClient.getBibaResponse().getFirst();
        BobaResponse bobaResponses = bobaClient.getBobaResponse().getFirst();
        System.out.println(bibaResponses.getId());
        System.out.println(bobaResponses.getName());



    }
}
