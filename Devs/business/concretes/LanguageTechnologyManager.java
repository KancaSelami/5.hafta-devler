package Kodlama.o.Devs.business.concretes;

import Kodlama.o.Devs.business.abstracts.LanguageTechnologyService;
import Kodlama.o.Devs.business.request.CreateLanguageTechnologyRequest;
import Kodlama.o.Devs.business.request.UpdateLanguageTechnologyRequest;
import Kodlama.o.Devs.business.response.FindAllLanguageTechnoloyResponse;
import Kodlama.o.Devs.business.response.FindByIdLanguageResponse;
import Kodlama.o.Devs.dataAccess.abstracts.LanguageTechnologyRepository;
import Kodlama.o.Devs.entities.concretes.LanguageTechnology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LanguageTechnologyManager implements LanguageTechnologyService {
    private LanguageTechnologyRepository languageTechnologyRepository;
    @Autowired
    public LanguageTechnologyManager(LanguageTechnologyRepository languageTechnologyRepository) {
        this.languageTechnologyRepository = languageTechnologyRepository;
    }

    @Override
    public List<FindAllLanguageTechnoloyResponse> findAll() {
        List<LanguageTechnology>languageTechnologies=languageTechnologyRepository.findAll();
        List<FindAllLanguageTechnoloyResponse>findAllLanguageTechnoloyResponses=new ArrayList<>();
        for(LanguageTechnology languageTechnology:languageTechnologies){
            FindAllLanguageTechnoloyResponse findAllLanguageTechnoloyResponse=new FindAllLanguageTechnoloyResponse();
            findAllLanguageTechnoloyResponse.setName(languageTechnology.getName());
            findAllLanguageTechnoloyResponse.setId(languageTechnology.getId());
            findAllLanguageTechnoloyResponses.add(findAllLanguageTechnoloyResponse);
        }
        return findAllLanguageTechnoloyResponses;
    }

    @Override
    public FindByIdLanguageResponse findById(int id) throws Exception {
        List<LanguageTechnology>languageTechnologies=languageTechnologyRepository.findAll();
        FindByIdLanguageResponse findByIdLanguageResponse=null;
        for(LanguageTechnology languageTechnology:languageTechnologies){
            if(languageTechnology.getId()==id){
                findByIdLanguageResponse=new FindByIdLanguageResponse();
                findByIdLanguageResponse.setId(languageTechnology.getId());
                findByIdLanguageResponse.setName(languageTechnology.getName());
            }
        }if(findByIdLanguageResponse==null){
            throw new Exception("Bu id'ye sahip dil teknolojisi mecvut degil!!"+id);
        }
        return findByIdLanguageResponse;
    }

    @Override
    public void add(CreateLanguageTechnologyRequest createLanguageTechnologyRequest) {
     LanguageTechnology languageTechnology=new LanguageTechnology();
     languageTechnology.setName(createLanguageTechnologyRequest.getName());
    languageTechnology.setId(createLanguageTechnologyRequest.getLanguageId());
     languageTechnologyRepository.save(languageTechnology);
    }

    @Override
    public void deleteById(int id) {
languageTechnologyRepository.deleteById(id);
    }

    @Override
    public void update(UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest, int id) {
        LanguageTechnology languageTechnology=languageTechnologyRepository.getReferenceById(id);
        languageTechnology.setName(updateLanguageTechnologyRequest.getName());
        languageTechnology.setId(updateLanguageTechnologyRequest.getLanguageId());
        languageTechnologyRepository.save(languageTechnology);

    }
}
