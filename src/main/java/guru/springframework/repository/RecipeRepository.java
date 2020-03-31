package guru.springframework.repository;

import guru.springframework.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

// The JPA Database CrudRepository extends cool methods that allows you to
// ask the database about properties using query methods.
public interface RecipeRepository extends CrudRepository<Recipe,Long> {

}
