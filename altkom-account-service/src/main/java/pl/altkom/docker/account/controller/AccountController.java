package pl.altkom.docker.account.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import pl.altkom.docker.account.controller.model.Account;
import pl.altkom.docker.account.service.AccountService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    @ApiOperation("Add new account")
    @PostMapping
    public Account addAccount(@RequestBody final Account account) {
        return accountService.addAccount(account);
    }

    @ApiOperation("Get all accounts")
    @GetMapping
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @ApiOperation("Remove account by id")
    @DeleteMapping("/{accountId}")
    public void deleteAccount(@PathVariable("accountId") final Long accountId) {
        accountService.deleteAccount(accountId);
    }

    @ApiOperation("Upload account image")
    @PostMapping(value = "/{accountId}/picture", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadPicture(@PathVariable("accountId") final Long accountId,
            @RequestParam final MultipartFile multipartFile) throws IOException {
        accountService.uploadPicture(accountId, multipartFile);
    }
}
