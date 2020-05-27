package Grupo13OO2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Grupo13OO2.Entities.Lote;

@Repository("loteRepository")
public interface ILoteRepository extends JpaRepository <Lote,Integer> {
    public abstract Lote findById(int id);
}
