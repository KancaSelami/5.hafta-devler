package Kodlama.o.Devs.business.concretes;

import Kodlama.o.Devs.business.abstracts.LanguegeService;
import Kodlama.o.Devs.business.request.CreateLanguageRequest;
import Kodlama.o.Devs.business.request.UpdateLanguageRequest;
import Kodlama.o.Devs.business.response.FindAllLanguageResponse;
import Kodlama.o.Devs.business.response.FindByIdLanguageResponse;
import Kodlama.o.Devs.core.LanguageCheckService;
import Kodlama.o.Devs.dataAccess.abstracts.LanguegeRepository;
import Kodlama.o.Devs.entities.concretes.Languege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LanguegeManager implements LanguegeService {



private LanguegeRepository languegeRepository;
private LanguageCheckService languageCheckService;
@Autowired
    public LanguegeManager(LanguegeRepository languegeRepository,LanguageCheckService languageCheckService) {
        this.languegeRepository = languegeRepository;
        this.languageCheckService=languageCheckService;
    }

    @Override
    public List<FindAllLanguageResponse> findAll() {
    List<Languege>langueges=languegeRepository.findAll();
    List<FindAllLanguageResponse>findAllLanguageResponses=new ArrayList<>();
    for(Languege languege:langueges){
        FindAllLanguageResponse findAllLanguageResponse=new FindAllLanguageResponse();
        findAllLanguageResponse.setName(languege.getName());
        findAllLanguageResponses.add(findAllLanguageResponse);

    }
        return findAllLanguageResponses;
    }

    @Override
    public FindByIdLanguageResponse findById(int id) throws Exception {
    List<Languege>langueges=languegeRepository.findAll();
    FindByIdLanguageResponse  findByIdLanguageResponse=null;
   for(Languege languege:langueges){
    if(languege.getId()==id){
        findByIdLanguageResponse =new FindByIdLanguageResponse();
        findByIdLanguageResponse.setName(languege.getName());
        findByIdLanguageResponse.setId(languege.getId());
    }

}
        if (findByIdLanguageResponse ==null) {
            throw  new Exception("Böylebir ID yoktur:"+id);
        }
   return findByIdLanguageResponse;
    }

    @Override
    public void add(CreateLanguageRequest createLanguageRequest) throws Exception {
    Languege languege=new Languege();
    languege.setName(createLanguageRequest.getName());
    if(languageCheckService.checkName(languege)){
        languegeRepository.save(languege);
    }else{
        throw  new Exception("ayni isimde dil eklenemez veya isim bos gecilemez!!!");

    }
    }

    @Override
    public void deleteById(int id) {

        languegeRepository.deleteById(id);
    }

    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest, int id) throws Exception {
    Languege languege=languegeRepository.getReferenceById(id);
    languege.setName(updateLanguageRequest.getName());
    languegeRepository.save(languege);

    }
}



