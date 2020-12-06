package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.model.Block;

@Repository
public interface BlockChainRepository extends JpaRepository<Block, Long> {

  // public Block findBlockByHash(String hash);
  public List<Block> findAllBlocks();
  // public Block saveBlock(Block block);
  //public Block updateBlockByHashByHash(String hash);
}