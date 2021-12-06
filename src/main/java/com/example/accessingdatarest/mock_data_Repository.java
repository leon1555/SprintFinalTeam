package com.example.accessingdatarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "mock_data", path="mock_data")
public interface mock_data_Repository extends PagingAndSortingRepository<mock_data, Integer> {

    List<mock_data>findById(@Param("id")int id);
    List<mock_data>findByBuzzwords(@Param("buzzwords")String buzzwords);
 //   List<mock_data>findByApp_Name(@Param("app_name")String app_name);
//    List<mock_data>findBycompany_names(@Param("company_names")String company_names);
//    List<mock_data>findByuser_agent(@Param("user_agent")String user_agent);

}
