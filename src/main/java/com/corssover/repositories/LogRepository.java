package com.corssover.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.corssover.domain.Log;




@Repository
public interface LogRepository extends JpaRepository<Log , Long>{
}
