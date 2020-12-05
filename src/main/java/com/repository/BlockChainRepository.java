package com.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.model.Block;

@Repository
public interface BlockChainRepository {

  public Block findBlockByHash(String hash);
  public List<Block> findAllBlocks();
  public Block saveBlock(Block block);
  public Block deleteBlock(Block block);
}