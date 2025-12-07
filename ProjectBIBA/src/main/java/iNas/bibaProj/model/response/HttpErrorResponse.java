package iNas.bibaProj.model.response;

import lombok.Builder;

@Builder
public record HttpErrorResponse(int code, String type, String message) {
}
