//package iNas.bibaProj.config;
//
//import io.micrometer.tracing.Tracer;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.client.RestTemplate;
//
//@Configuration
//public class TracingConfig {
//    @Bean
//    public RestTemplate restTemplate(Tracer tracer) {
//        RestTemplate restTemplate = new RestTemplate();
//
//        restTemplate.getInterceptors().add((request, body, execution) -> {
//            if (tracer.currentSpan() != null) {
//                var context = tracer.currentSpan().context();
//                request.getHeaders().add("traceparent",
//                        String.format("00-%s-%s-01",
//                                context.traceId(),
//                                context.spanId()));
//            }
//            return execution.execute(request, body);
//        });
//        return restTemplate;
//    }
//}