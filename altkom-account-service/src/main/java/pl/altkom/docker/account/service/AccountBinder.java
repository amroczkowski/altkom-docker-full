package pl.altkom.docker.account.service;

import pl.altkom.docker.account.controller.model.Account;

public class AccountBinder {

    public static Account bindAccount(final pl.altkom.docker.account.repository.model.Account account) {
        return Account.builder()
                .id(account.getId())
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .pesel(account.getPesel())
                .build();
    }
}
