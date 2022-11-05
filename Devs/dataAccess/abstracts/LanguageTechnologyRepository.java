package Kodlama.o.Devs.dataAccess.abstracts;

import Kodlama.o.Devs.entities.concretes.LanguageTechnology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageTechnologyRepository extends JpaRepository<LanguageTechnology,Integer> {
}
