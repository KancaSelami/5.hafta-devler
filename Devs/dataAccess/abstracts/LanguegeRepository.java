package Kodlama.o.Devs.dataAccess.abstracts;


import Kodlama.o.Devs.entities.concretes.Languege;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguegeRepository extends JpaRepository<Languege,Integer> {


}
