package Kodlama.o.Devs.entities.concretes;


import lombok.*;

import javax.persistence.*;
import java.util.Set;


@NoArgsConstructor
@Data
@Entity

public class Languege {

@Id
@Column(name = "id")
@GeneratedValue
private int id;


@Column(name = "name")
private String name;

@OneToMany(mappedBy = "languege")
private Set<LanguageTechnology> technologies;

}

