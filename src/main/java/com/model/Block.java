package com.model;

public class Block {
 
    private String hash; 
    private String parentHash; 
    private String data; 


    // Constructor for the block 
    public Block(String data, String parentHash) 
    { 
        this.data = data; 
        this.parentHash = parentHash;
        this.hash="first-hash"; 

    }
 
    //Getters and setters
    public void setHash(String hash) {
        this.hash = hash;
      }

      public String getHash() {
        return this.hash;
      }

      public String getParentHash() {
        return this.parentHash;
      }

      public String getData() {
        return this.data;
      }
 
    @Override
    public String toString() {
        return "Block [hash=" + hash + ", parentHash=" + parentHash + ", data=" + data + "]";
    }
}
