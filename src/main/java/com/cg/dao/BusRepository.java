package com.cg.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.entity.Bus;

@Repository
public interface BusRepository extends JpaRepository<Bus,String>{

	@Query("from Bus b where b.src=?1 and locate(?2,b.dest)>0")
	List<Bus> findBySrcAndDest(String src,String dest);
	
}