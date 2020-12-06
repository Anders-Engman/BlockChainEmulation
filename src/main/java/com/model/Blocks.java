package com.model;

import java.util.ArrayList;
import java.util.List;
 
public class Blocks 
{
    private List<Block> blockList;
     
    public List<Block> getBlockList() {
        if(blockList == null) {
            blockList = new ArrayList<>();
        }
        return blockList;
    }
  
    public void setBlockList(List<Block> blockList) {
        this.blockList = blockList;
    }
}
