package guru.springframework.repository;

import guru.springframework.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

// The JPA Database CrudRepository extends cool methods that allows you to
// ask the database about properties using query methods.
public interface CategoryRepository extends CrudRepository<Category,Long> {

        Optional<Category> findCategoriesByDescription(String description);

        Iterable<Category> findAll();

}
