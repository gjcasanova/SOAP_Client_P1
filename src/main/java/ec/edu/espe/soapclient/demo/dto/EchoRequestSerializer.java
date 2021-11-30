package ec.edu.espe.soapclient.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class EchoRequestSerializer {
    private String echoType;
}
