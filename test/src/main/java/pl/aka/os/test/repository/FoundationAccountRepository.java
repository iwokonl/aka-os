package pl.aka.os.test.repository;

import pl.aka.os.test.model.FoundationAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface FoundationAccountRepository extends JpaRepository<FoundationAccount, UUID> {

    Optional<FoundationAccount> findById(UUID id);
}
