package iNas.responses;

import lombok.Data;

import java.util.UUID;

@Data
public class BobaResponse {
    private UUID id;
    private String name;
}