package iNas.service;

import iNas.responses.BibaResponse;
import iNas.responses.BobaResponse;
import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@AllArgsConstructor
public class BobaService {
    private final RestTemplate restTemplate;
    private final String BOBA_URL = "http://localhost/boba/";

    public List<BobaResponse> shouldBobaServer() {
        ParameterizedTypeReference<List<BobaResponse>> reference = new ParameterizedTypeReference<>(){};
        return restTemplate.exchange(BOBA_URL, HttpMethod.GET, null, reference).getBody();
    }
}