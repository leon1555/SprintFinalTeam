package com.keyin.team3.repository.mysql;

import com.keyin.team3.model.mysql.History;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RepositoryRestResource(collectionResourceRel = "history", path = "history")
public interface HistoryRepository extends PagingAndSortingRepository<History, Long> {
  List<History> findByUserId(@Param("userId") int userId);
}
