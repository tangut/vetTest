package com.repos;

import com.domain.Pet;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PetRepo  extends CrudRepository<Pet, Long> {

    List<Pet> findByKind(String kind);

}
