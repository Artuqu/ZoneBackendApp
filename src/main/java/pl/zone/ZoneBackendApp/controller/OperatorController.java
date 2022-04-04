package pl.zone.ZoneBackendApp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zone.ZoneBackendApp.dto.OperatorAuthenticationResult;
import pl.zone.ZoneBackendApp.dto.OperatorCredentials;
import pl.zone.ZoneBackendApp.entity.Operator;
import pl.zone.ZoneBackendApp.repository.OperatorRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class OperatorController {

    private final OperatorRepository or;

    @PostMapping("/operators")
    public Operator newOperator(@RequestBody Operator newOperator) {
        return or.save(newOperator);
    }

    @GetMapping("/operators")
    public List<Operator> listOperators() {
        return or.findAll();
    }

    @DeleteMapping("/operators")
    public ResponseEntity deleteOperator(@RequestBody Long idOperator) {
        or.deleteById(idOperator);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/verify")
    public OperatorAuthenticationResult verifyCredentials(@RequestBody OperatorCredentials operatorCredentials){
        Optional<Operator> findLogin = or.findByLogin(operatorCredentials.getLogin());
        if(!findLogin.isPresent()){
            System.out.println("That user name does not exist");
            return OperatorAuthenticationResult.createUnauthenticated();
        }
        Operator op = findLogin.get();
        if (!op.getPassword().equals(operatorCredentials.getPassword())){
        return OperatorAuthenticationResult.createUnauthenticated();
        } else
        return OperatorAuthenticationResult.of(op);
    }


}
