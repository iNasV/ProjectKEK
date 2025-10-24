package iNas.repository;

import iNas.entity.ExampleBobaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExampleBobaRepository extends JpaRepository<ExampleBobaEntity, UUID> {
}
