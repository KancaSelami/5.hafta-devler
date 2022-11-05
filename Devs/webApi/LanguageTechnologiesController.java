package Kodlama.o.Devs.webApi;

import Kodlama.o.Devs.business.abstracts.LanguageTechnologyService;
import Kodlama.o.Devs.business.request.CreateLanguageTechnologyRequest;
import Kodlama.o.Devs.business.request.UpdateLanguageTechnologyRequest;
import Kodlama.o.Devs.business.response.FindAllLanguageTechnoloyResponse;
import Kodlama.o.Devs.business.response.FindByIdLanguageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/controllers")
public class LanguageTechnologiesController {
    private LanguageTechnologyService languageTechnologyService;
@Autowired
    public LanguageTechnologiesController(LanguageTechnologyService languageTechnologyService) {
        this.languageTechnologyService = languageTechnologyService;
    }
    @GetMapping("/getLanguageTechnolog")
    public List<FindAllLanguageTechnoloyResponse> getLanguageTechnologj(){
        return languageTechnologyService.findAll();
    }
    @GetMapping ("/getLanguageTechnology/{id}")
    public FindByIdLanguageResponse findAllLanguageTechnoloyResponse(@PathVariable int id) throws Exception {
        return  languageTechnologyService.findById(id);

    }
    @PostMapping("/addLanguageTechnology")
    public void addLanguageTechnology(@RequestBody CreateLanguageTechnologyRequest createLanguageTechnologyRequest){
        languageTechnologyService.add(createLanguageTechnologyRequest);
    }
    @DeleteMapping("/deleteLanguageTechnology/{id}")
    public void deleteLanguageTechnology(@PathVariable int id){
        languageTechnologyService.deleteById(id);
    }
    @PutMapping("/updateLanguageTechnolog/{id}")
    public void updateLanguageTechnology(@RequestBody UpdateLanguageTechnologyRequest updateLanguageTechnologyRequest, @PathVariable int id){
        languageTechnologyService.update(updateLanguageTechnologyRequest,id);
    }
}
