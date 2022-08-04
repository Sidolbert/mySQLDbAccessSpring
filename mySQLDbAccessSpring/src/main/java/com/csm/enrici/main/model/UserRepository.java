package com.csm.enrici.main.model;

import javax.persistence.Id;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//interface qui va lister les méthodes utilisées pour lier mon User à la BDD
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	
	//on peut déclarer des méthodes supplémentaires par rapport à celles de CrudRepository
	//selon nos besoins, comme par exemple findByUsername

}
