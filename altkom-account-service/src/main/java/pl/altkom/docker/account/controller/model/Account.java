package pl.altkom.docker.account.controller.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Account {

    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;
}
