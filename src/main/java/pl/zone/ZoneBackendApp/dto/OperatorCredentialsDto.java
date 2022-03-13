package pl.zone.ZoneBackendApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class OperatorCredentialsDto {

    private String login;
    private String password;

}
