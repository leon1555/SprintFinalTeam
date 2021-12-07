package com.example.accessingdatarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "mock_data", path="mock_data")
public interface mock_data_Repository extends PagingAndSortingRepository<mock_data, Integer> {

    List<mock_data>findById(@Param("id")int id);
    List<mock_data>findByBuzzwords(@Param("Buzzwords")String Buzzwords);
    List<mock_data>findByAppNames(@Param("AppNames")String AppNames);
    List<mock_data>findByCompanyNames(@Param("CompanyNames")String CompanyNames);
    List<mock_data>findByUserAgent(@Param("UserAgent")String UserAgent);

}
