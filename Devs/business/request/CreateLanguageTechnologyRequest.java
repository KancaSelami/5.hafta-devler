package Kodlama.o.Devs.business.request;

import Kodlama.o.Devs.entities.concretes.Languege;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateLanguageTechnologyRequest {
    private String name;
    private int languageId;

}
