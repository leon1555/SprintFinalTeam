package com.example.accessingdatarest;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "mock_data", path="mock_data")
public interface mock_data_Repository extends PagingAndSortingRepository<mock_data, Integer> {

    List<mock_data>findById(@Param("id")int id);
    List<mock_data>findByBuzzwords(@Param("buzzwords")String buzzwords);
    List<mock_data>findByAppnames(@Param("appnames")String appnames);
    List<mock_data>findByCompanynames(@Param("companynames")String companynames);
    List<mock_data>findByUseragent(@Param("useragent")String useragent);

}
