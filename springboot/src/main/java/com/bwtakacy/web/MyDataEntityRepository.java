package com.bwtakacy.web;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyDataEntityRepository
  extends JpaRepository<MyDataEntity, Integer> {
	
	List<MyDataEntity> findByName(String name);

}
