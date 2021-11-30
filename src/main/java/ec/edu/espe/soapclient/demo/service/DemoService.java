package ec.edu.espe.soapclient.demo.service;

import ec.edu.espe.soapclient.demo.dto.EchoRequestSerializer;
import ec.edu.espe.soapclient.demo.dto.EchoResponseSerializer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import soapserver.wsdl.*;

@Service
@Slf4j
public class DemoService extends WebServiceGatewaySupport {

    public static final String soapServiceEndpoint = "http://localhost:8080/ws/demo.wsdl";

    public EchoResponseSerializer echo(EchoRequestSerializer request){
        GetEchoRequest soapRequest = new GetEchoRequest();
        soapRequest.setEchoType(request.getEchoType());
        log.info(request.getEchoType());
        GetEchoResponse soapResponse = (GetEchoResponse) getWebServiceTemplate().marshalSendAndReceive(soapServiceEndpoint, soapRequest);
        EchoResponseSerializer restResponse = EchoResponseSerializer.builder()
                .echoType(request.getEchoType())
                .message(soapResponse.getMessage()).build();

        return restResponse;
    }


    public GetAvailableMatchResponse getAvailableMatches(){
        GetAvailableMatchRequest soapRequest = new GetAvailableMatchRequest();
        GetAvailableMatchResponse soapResponse = (GetAvailableMatchResponse) getWebServiceTemplate().marshalSendAndReceive(soapServiceEndpoint, soapRequest);
        return soapResponse;
    }

    public GetLocalitiesResponse getLocalities(int id){
        GetLocalitiesRequest soapRequest = new GetLocalitiesRequest();
        soapRequest.setMatchId(id);
        GetLocalitiesResponse soapResponse = (GetLocalitiesResponse) getWebServiceTemplate().marshalSendAndReceive(soapServiceEndpoint, soapRequest);
        return soapResponse;
    }

    public GetLocalitiesResponse buyLocation(int id){
        BuyLocationRequest soapRequest = new BuyLocationRequest();
        soapRequest.setLocationId(id);
        GetLocalitiesResponse soapResponse = (GetLocalitiesResponse) getWebServiceTemplate().marshalSendAndReceive(soapServiceEndpoint, soapRequest);
        return soapResponse;
    }
}
