package Kodlama.o.Devs.entities.concretes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class LanguageTechnology {

@Id
@Column(name = "id")
@GeneratedValue
private int id;
@Column(name = "name")
private String name;

@ManyToOne
private Languege languege;
}
