package Kodlama.o.Devs.core;

import Kodlama.o.Devs.dataAccess.abstracts.LanguegeRepository;
import Kodlama.o.Devs.entities.concretes.Languege;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageCheckService {
    private LanguegeRepository languegeRepository;
    @Autowired
    public LanguageCheckService(LanguegeRepository languegeRepository){
        this.languegeRepository=languegeRepository;
    }
    public boolean checkName(Languege languege) {
        List<Languege> langueges = languegeRepository.findAll();
    for(Languege languege1:langueges){
        if(languege1.getName().equalsIgnoreCase(languege.getName())){

            return false;
        }
    }
    if(languege.getName()==null){
        return false;
    }
    return true;
    }
}
