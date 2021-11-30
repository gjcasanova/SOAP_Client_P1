package ec.edu.espe.soapclient.demo.controller;

import ec.edu.espe.soapclient.demo.dto.EchoRequestSerializer;
import ec.edu.espe.soapclient.demo.dto.EchoResponseSerializer;
import ec.edu.espe.soapclient.demo.service.DemoService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soapserver.wsdl.GetAvailableMatchResponse;
import soapserver.wsdl.GetLocalitiesResponse;

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

    @GetMapping("/matches")
    public ResponseEntity getAvailableMatches(){
        try{
            GetAvailableMatchResponse response = demoService.getAvailableMatches();
            return ResponseEntity.ok(response.getMatch());
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @GetMapping("/matches/{id}/locations")
    public ResponseEntity getMatchLocations(@PathVariable int id){
        try{
            GetLocalitiesResponse response = demoService.getLocalities(id);
            return ResponseEntity.ok(response.getLocation());
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }

    @PostMapping("/locations/buy/{id}/")
    public ResponseEntity buyLocation(@PathVariable int id){
        try{
            GetLocalitiesResponse response = demoService.buyLocation(id);
            return ResponseEntity.ok(response.getLocation());
        }catch (Exception ex){
            return ResponseEntity.badRequest().body(ex.getMessage());
        }
    }
}
