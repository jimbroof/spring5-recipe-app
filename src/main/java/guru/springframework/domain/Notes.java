package guru.springframework.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    private Recipe recipe;

    // JPA assigns it in a clob field in the database
    @Lob
    private String recipeNotes;

    @Lob
    private String notes;

}
