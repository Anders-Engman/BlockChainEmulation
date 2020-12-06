package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.model.Block;

@Repository
public interface BlockRepository extends JpaRepository<Block, Long>{

}