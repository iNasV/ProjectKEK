package iNas.unknownProj.feign;

import iNas.unknownProj.responses.BibaResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "bibaClient", url = "http://localhost:80/biba/")
public interface BibaClient {

    @GetMapping
    List<BibaResponse> getBibaResponse();

}