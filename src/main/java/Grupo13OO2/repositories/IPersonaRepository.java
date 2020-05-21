package Grupo13OO2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Grupo13OO2.Entities.Persona;

public interface IPersonaRepository extends JpaRepository <Persona,Integer> {
}