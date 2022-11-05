package Kodlama.o.Devs.business.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindByIdTechnologyResponse {
    private int id;
    private String name;
}
