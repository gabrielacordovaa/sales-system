package com.cordovagabriela.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cordovagabriela.system.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String>{

}
