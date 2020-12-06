package com.dao;

import com.model.Blocks;
import com.model.Block;

import org.springframework.stereotype.Repository;

@Repository
public class BlockDAO {
    private static Blocks list = new Blocks();

    static
    {
        list.getBlockList().add(new Block("Lokesh", "Gupta"));
    }
     
    public Blocks getAllBlocks() {
        return list;
    }
     
    public void addBlock(Block block) {
        list.getBlockList().add(block);
    }
}