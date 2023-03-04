package at.itkolleg.growmanager.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FertilizerType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    @NotNull(message = "Der Name des Düngertyps darf nicht leers ein!")
    @Size(min = 2, max = 255, message = "Der Düngertyp '${validatedValue}' ist ungültig. Düngertypem müssen zwischen {min} uhd {max} sein!")
    private String name;

    public FertilizerType(String name){
        this.name = name;
    }
}
