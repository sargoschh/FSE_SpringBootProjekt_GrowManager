package at.itkolleg.growmanager.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    @NotNull(message = "Der Pflanzenname darf nicht leer sein!")
    @Size(min = 2, max = 255, message = "Der Pflanzenname '${validatedValue}' ist ungültig. Pflanzennamen müssen zwischen {min} und {max} Zeichen lang sein.")
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private PlantType type;

    @Min(1)
    @Max(365)
    //@Pattern(regexp="^(0|[1-9][0-9]*)$", message = "Bitte nur numerische Werte eingeben!")
    private Integer growthPeriod;

    public Plant(String name, PlantType type, Integer growthPeriod) {
        this.name = name;
        this.type = type;
        this.growthPeriod = growthPeriod;
    }
}
