package Kodlama.o.Devs.business.abstracts;

import Kodlama.o.Devs.business.request.CreateLanguageRequest;
import Kodlama.o.Devs.business.request.UpdateLanguageRequest;
import Kodlama.o.Devs.business.response.FindAllLanguageResponse;
import Kodlama.o.Devs.business.response.FindByIdLanguageResponse;


import java.util.List;

public interface LanguegeService {
List<FindAllLanguageResponse> findAll();
FindByIdLanguageResponse findById(int id)throws Exception;
void add(CreateLanguageRequest createLanguageRequest)throws Exception;
void deleteById(int id);
void update (UpdateLanguageRequest updateLanguageRequest ,int id)throws Exception;
}
