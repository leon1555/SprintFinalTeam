package com.example.accessingdatarest;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "mysqlmockdata", path = "mysqlmockdata")
public interface mysqlRepository extends PagingAndSortingRepository<mysqlmockdata, Long> {

    List<mysqlmockdata> findById(@Param("id") long id);
    List<mysqlmockdata> findByCarmake(@Param("carmake") String carmake);
    List<mysqlmockdata> findByCarmodel(@Param("carmodel") String carmodel);
    List<mysqlmockdata> findByColor(@Param("color") String color);
    List<mysqlmockdata> findByGender(@Param("gender")String gender);

}