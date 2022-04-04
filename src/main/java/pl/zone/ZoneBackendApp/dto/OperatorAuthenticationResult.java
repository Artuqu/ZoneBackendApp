package pl.zone.ZoneBackendApp.dto;

import lombok.Data;
import pl.zone.ZoneBackendApp.entity.Operator;

@Data
public class OperatorAuthenticationResult {

    private Long idOperator;
    private String firstName;
    private String lastName;
    private boolean authenticated;

    public static OperatorAuthenticationResult createUnauthenticated(){
        OperatorAuthenticationResult dto = new OperatorAuthenticationResult();
        dto.setAuthenticated(false);
        return dto;
    }

    public static OperatorAuthenticationResult of (Operator operator){
        OperatorAuthenticationResult dto = new OperatorAuthenticationResult();
        dto.setAuthenticated(true);
        dto.setFirstName(operator.getEmployee().getFirstName());
        dto.setLastName(operator.getEmployee().getLastName());
        dto.setIdOperator(operator.getIdOperator());
        return dto;
    }

}
