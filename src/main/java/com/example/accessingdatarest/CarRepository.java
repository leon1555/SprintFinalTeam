package com.example.accessingdatarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "car", path = "car")
public interface CarRepository extends PagingAndSortingRepository<Car, Long> {

    List<Car> findByModel(@Param("model") String model);
    List<Car> findByMake(@Param("make") String make);
    List<Car> findByYear(@Param("year") String year);
    List<Car> findByModelAndYear(@Param("model") String model, @Param("year") String year);

}
