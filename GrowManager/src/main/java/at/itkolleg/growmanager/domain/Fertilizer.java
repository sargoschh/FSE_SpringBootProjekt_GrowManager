package at.itkolleg.growmanager.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Fertilizer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    @NotNull(message = "Der ")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private FertilizerType type;

    @Min(0)
    @Max(1000)
    private Float dosage;

    public Fertilizer(String name, FertilizerType type, Float dosage){
        this.name = name;
        this.type = type;
        this.dosage = dosage;
    }
}
