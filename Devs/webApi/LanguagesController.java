package Kodlama.o.Devs.webApi;

import Kodlama.o.Devs.business.abstracts.LanguegeService;
import Kodlama.o.Devs.business.request.CreateLanguageRequest;
import Kodlama.o.Devs.business.request.UpdateLanguageRequest;
import Kodlama.o.Devs.business.response.FindAllLanguageResponse;
import Kodlama.o.Devs.business.response.FindByIdLanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Languages")
public class LanguagesController {
    private LanguegeService languegeService;

    @Autowired
    public LanguagesController(LanguegeService languegeService) {
        this.languegeService = languegeService;
    }
    @GetMapping("/getLanguage")
    public List<FindAllLanguageResponse> getLanguage(){
        return languegeService.findAll();
    }
    @GetMapping ("getByIdLanguage/{id}")
    public FindByIdLanguageResponse getByIdLanguage(@PathVariable int id) throws Exception {
        return languegeService.findById(id);
    }
    @PostMapping("/addLanguage")
    public void  addLanguage(@RequestBody CreateLanguageRequest createLanguageRequest) throws Exception {
        languegeService.add(createLanguageRequest);
    }
    @DeleteMapping("deleteLanguage/{id}")
    public void delete(@PathVariable int id){
        languegeService.deleteById(id);
    }

    @PutMapping("/updateLanguage/{id}")
    public void updateLanguage(@RequestBody UpdateLanguageRequest updateLanguageRequest, @PathVariable int id) throws Exception {
        languegeService.update(updateLanguageRequest,id);
    }
}
