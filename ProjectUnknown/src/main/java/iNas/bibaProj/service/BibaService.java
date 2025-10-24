package iNas.service;

import iNas.responses.BibaResponse;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

@Service
@AllArgsConstructor
public class BibaService {
    private final RestTemplate restTemplate;
    private final String BIBA_URL = "http://localhost/biba/";

    public List<BibaResponse> shouldBibaServer() {
        ParameterizedTypeReference<List<BibaResponse>> reference = new ParameterizedTypeReference<>(){};
        return restTemplate.exchange(BIBA_URL, HttpMethod.GET, null, reference).getBody();
    }
}
