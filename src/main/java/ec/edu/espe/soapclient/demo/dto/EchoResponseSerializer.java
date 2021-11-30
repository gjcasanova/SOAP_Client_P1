package ec.edu.espe.soapclient.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EchoResponseSerializer {
    private String echoType;
    private String message;
}
