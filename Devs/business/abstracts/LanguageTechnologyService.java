package Kodlama.o.Devs.business.abstracts;

import Kodlama.o.Devs.business.request.CreateLanguageTechnologyRequest;
import Kodlama.o.Devs.business.request.UpdateLanguageTechnologyRequest;
import Kodlama.o.Devs.business.response.FindAllLanguageTechnoloyResponse;
import Kodlama.o.Devs.business.response.FindByIdLanguageResponse;

import java.util.List;

public interface LanguageTechnologyService {
    List<FindAllLanguageTechnoloyResponse>findAll();
    FindByIdLanguageResponse findById(int id)throws Exception;
void add(CreateLanguageTechnologyRequest createLanguageTechnologyRequest);
void deleteById(int id);
void update(UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest,int id);


}
