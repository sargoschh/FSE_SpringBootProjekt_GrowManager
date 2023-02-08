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
public class PlantType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    @NotNull(message = "Der Name des Pflanzentyps darf nicht leer sein!")
    @Size(min = 2, max = 255, message = "Der Pflanzentyp darf nicht leer sein!")
    private String name;

    public PlantType(String name) {
        this.name = name;
    }
}
