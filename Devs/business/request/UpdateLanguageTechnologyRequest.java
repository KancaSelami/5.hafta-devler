package Kodlama.o.Devs.business.request;

import Kodlama.o.Devs.entities.concretes.Languege;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateLanguageTechnologyRequest {
    private String name;
    private int languageId;






}
