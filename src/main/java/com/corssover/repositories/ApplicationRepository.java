package com.corssover.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corssover.domain.Application;



@Repository
public interface ApplicationRepository extends JpaRepository<Application , Long>{
}
