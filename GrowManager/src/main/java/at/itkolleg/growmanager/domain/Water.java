package at.itkolleg.growmanager.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Water {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull(message = "Es muss ein Grow angegeben werden!")
    @ManyToOne
    @JoinColumn(name = "grow_id")
    private Grow grow;

    @Min(1)
    @Max(10000)
    private Float amountOfWater;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;


    private String comment;

    @Min(1)
    @Max(1000)
    private Float dosageFertilizer;


    public Water(Grow grow, Float amountOfWater, LocalDate date, String comment, Float dosageFertilizer){
        this.grow = grow;
        this.amountOfWater = amountOfWater;
        this.date = date;
        this.comment = comment;
        this.dosageFertilizer = dosageFertilizer;
    }
}
