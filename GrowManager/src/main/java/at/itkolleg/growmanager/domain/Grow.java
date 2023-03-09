package at.itkolleg.growmanager.domain;

import at.itkolleg.growmanager.Assert;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Grow {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "plant_id")
    private Plant plant;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate estimatedEndDate;

    private Float potSize;

    private Boolean harvested;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate actualEndDate;

    public Grow(Plant plant, LocalDate startDate, LocalDate estimatedEndDate,
                Float potSize, Boolean harvested, LocalDate actualEndDate) {
        this.plant = plant;
        this.startDate = startDate;
        this.estimatedEndDate = estimatedEndDate;
        this.potSize = potSize;
        this.harvested = harvested;
        this.actualEndDate = actualEndDate;
    }

    public void setStartDate(LocalDate startDate) {
        if(Assert.validationDateBeforeToday(startDate)) {
            this.startDate = startDate;
        }
    }


}
