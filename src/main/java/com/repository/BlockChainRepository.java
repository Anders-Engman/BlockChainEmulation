package com.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.model.Block;

@Repository
public interface BlockChainRepository extends CrudRepository<Block, Long>, JpaSpecificationExecutor<Block> {

  public Block findBlockByHash(String hash);
  public List<Block> findAllBlocks();
  public Block saveBlock(Block block);
  public Block deleteBlock(Block block);
}