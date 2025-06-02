package pl.aka.os.test.repository;

import pl.aka.os.test.model.Box;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BoxRepository extends JpaRepository<Box, UUID> {


}
