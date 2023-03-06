package at.itkolleg.growmanager.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Benutzer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull(message = "Der Name darf nicht leer sein!")
    @Size(min = 2, max = 255, message = "Der Name '${validatedValue}' ist ungültig. Namen müssen zwischen {min} und {max} Zeichen lang sein.")
    private String name;

    @NotNull(message = "Der Username darf nicht leer sein!")
    @Size(min = 2, max = 255, message = "Der Username '${validatedValue}' ist ungültig. Usernames müssen zwischen {min} und {max} Zeichen lang sein.")
    private String username;

    @NotNull(message = "Das Passwort darf nicht leer sein!")
    @Size(min = 2, max = 255, message = "Das Passwort '${validatedValue}' ist ungültig. Passwörter müssen zwischen {min} und {max} Zeichen lang sein.")
    private String password;

    public Benutzer(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
}
