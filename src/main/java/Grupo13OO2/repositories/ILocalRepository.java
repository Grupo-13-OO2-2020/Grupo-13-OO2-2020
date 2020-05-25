package Grupo13OO2.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Grupo13OO2.Entities.Local;

@Repository("localRepository")
public interface ILocalRepository extends JpaRepository <Local,Integer> {
	 public abstract Local findById(int id);
}
