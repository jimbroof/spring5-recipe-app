package guru.springframework.repository;

import guru.springframework.domain.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// The JPA Database CrudRepository extends cool methods that allows you to
// ask the database about properties using query methods.
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure,Long> {

    Optional<UnitOfMeasure> findUnitOfMeasureByDescription(String description);






}
