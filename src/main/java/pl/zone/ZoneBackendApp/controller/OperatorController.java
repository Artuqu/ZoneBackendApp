package pl.zone.ZoneBackendApp.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zone.ZoneBackendApp.dto.OperatorAuthenticationResultDto;
import pl.zone.ZoneBackendApp.dto.OperatorCredentialsDto;
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
    public OperatorAuthenticationResultDto verifyCredentials(@RequestBody OperatorCredentialsDto operatorCredentialsDto){
        Optional<Operator> findLogin = or.findByLogin(operatorCredentialsDto.getLogin());
        if(!findLogin.isPresent()){
            System.out.println("That user name does not exist");
            return OperatorAuthenticationResultDto.createUnauthenticated();
        }
        Operator op = findLogin.get();
        if (!op.getPassword().equals(operatorCredentialsDto.getPassword())){
        return OperatorAuthenticationResultDto.createUnauthenticated();
        } else
        return OperatorAuthenticationResultDto.of(op);
    }


}
