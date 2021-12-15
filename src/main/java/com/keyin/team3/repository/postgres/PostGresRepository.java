package com.keyin.team3.repository.postgres;

import com.keyin.team3.model.postgres.PostGresMockData;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RepositoryRestResource(collectionResourceRel = "mock_data", path="mock_data")
public interface PostGresRepository extends PagingAndSortingRepository<PostGresMockData, Integer> {

    List<PostGresMockData>findById(@Param("id")int id);
    List<PostGresMockData>findByBuzzwords(@Param("buzzwords")String buzzwords);
    List<PostGresMockData>findByAppnames(@Param("appnames")String appnames);
    List<PostGresMockData>findByCompanynames(@Param("companynames")String companynames);
    List<PostGresMockData>findByUseragent(@Param("useragent")String useragent);

}
