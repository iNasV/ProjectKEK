package iNas.repository;

import iNas.entity.ExampleBobaEntity;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ExampleBobaRepository extends CrudRepository<ExampleBobaEntity, UUID> {

    @Modifying
    @Query("INSERT INTO public.example (id, name) VALUES (:id, :name)")
    void insert(@Param("id") UUID id, @Param("name") String name);

}