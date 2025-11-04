package iNas.unknownProj.feign;

import iNas.unknownProj.responses.BobaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "bobaClient", url = "http://localhost:80/boba/")
public interface BobaClient {

    @GetMapping
    List<BobaResponse> getBobaResponse();

}