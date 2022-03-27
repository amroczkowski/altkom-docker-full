package pl.altkom.docker.account.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import pl.altkom.docker.account.configuration.PathsConfiguration;
import pl.altkom.docker.account.controller.model.Account;
import pl.altkom.docker.account.repository.AccountRepository;

@Slf4j
@RequiredArgsConstructor
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final PathsConfiguration pathsConfiguration;

    public Account addAccount(final Account account) {

        log.info("Adding new account");

        return AccountBinder.bindAccount(accountRepository.save(pl.altkom.docker.account.repository.model.Account.builder()
                .firstName(account.getFirstName())
                .lastName(account.getLastName())
                .pesel(account.getPesel())
                .build()));
    }

    public List<Account> getAccounts() {

        log.info("Getting accounts");

        return accountRepository.findAll().stream()
                .map(AccountBinder::bindAccount)
                .collect(Collectors.toList());
    }

    public void deleteAccount(final Long accountId) {

        log.info("Removing account {}", accountId);

        accountRepository.deleteById(accountId);
    }

    public void uploadPicture(final Long accountId, final MultipartFile multipartFile) throws IOException {

        log.info("Uploading account {} image", accountId);

        accountRepository.findById(accountId).orElseThrow();
        final Path path = Paths.get(String.format("%s%saccount_%d.jpg", pathsConfiguration.getPictures(), "/",
                accountRepository.findById(accountId).orElseThrow().getId()));
        Files.write(path, multipartFile.getBytes());

        log.info("Uploaded account {} image", accountId);
    }
}
