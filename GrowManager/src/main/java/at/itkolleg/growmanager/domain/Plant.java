package at.itkolleg.growmanager.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    @NotNull(message = "Der Pflanzenname darf nicht leer sein!")
    @Size(min = 2, max = 255, message = "Der Pflanzenname '${validatedValue}' ist ungültig. Pflanzennamen müssen zwischen {min} und {max} Zeichen lang sein.")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PlantType type;

    @Min(1)
    @Max(365)
    private Integer growthPeriod;
}
