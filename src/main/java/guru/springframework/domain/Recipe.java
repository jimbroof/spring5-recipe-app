package guru.springframework.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"notes","categories"})
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;

    @Lob
    private String directions;

    // Defines the relationship.
    // shows that recipe is a property in ingredient
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
    private Set<Ingredient> ingredients = new HashSet<>();

    // JPA assigns it in a Byte array field in the database
    // Large object Storage
    @Lob
    private Byte[] image;

    // Will store the String value of the ENUM in the database. It is more consistent than using ordinal
    @Enumerated(value = EnumType.STRING)
    private Difficulty difficulty;


    // if property is deleted in Recipe, it will also be deleted in Notes
    @OneToOne( cascade= CascadeType.ALL)
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "recipe_category",
                joinColumns= @JoinColumn(name="recipe_id"),
                    inverseJoinColumns = @JoinColumn(name="category_id")
            )

    private Set<Category> categories = new HashSet<>();


    public void setNotes(Notes note) {
        this.notes = note;
    }

    public Recipe addIngredient(Ingredient ingredient){
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

}
