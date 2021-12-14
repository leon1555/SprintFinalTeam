package com.keyin.team3.repository.mysql;

import java.util.List;

import com.keyin.team3.model.mysql.MySQLMockData;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "mysqlmockdata", path = "mysqlmockdata")
public interface MySQLRepository extends PagingAndSortingRepository<MySQLMockData, Long> {

    List<MySQLMockData> findById(@Param("id") long id);
    List<MySQLMockData> findByCarmake(@Param("carmake") String carmake);
    List<MySQLMockData> findByCarmodel(@Param("carmodel") String carmodel);
    List<MySQLMockData> findByColor(@Param("color") String color);
    List<MySQLMockData> findByGender(@Param("gender")String gender);

}