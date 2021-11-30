package ec.edu.espe.soapclient.demo.controller;

import ec.edu.espe.soapclient.demo.dto.EchoRequestSerializer;
import ec.edu.espe.soapclient.demo.dto.EchoResponseSerializer;
import ec.edu.espe.soapclient.demo.service.DemoService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/soap-bridge")
@Data
@Slf4j
public class DemoController {

    @Autowired
    private final DemoService demoService;

    @PostMapping("/echo")
    public ResponseEntity echo(@RequestBody EchoRequestSerializer request){
        try{
            EchoResponseSerializer response = demoService.echo(request);
            return ResponseEntity.ok(response);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
