package iNas.bibaProj.repository;

import iNas.bibaProj.entity.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExampleRepository extends JpaRepository<Example, UUID> {
}
