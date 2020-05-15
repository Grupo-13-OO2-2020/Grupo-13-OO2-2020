package Grupo13OO2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import Grupo13OO2.Entities.Cliente;

public interface IClienteRepository extends JpaRepository <Cliente,Integer>{
    
}