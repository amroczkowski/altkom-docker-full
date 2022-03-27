package pl.altkom.docker.account.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.altkom.docker.account.repository.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
