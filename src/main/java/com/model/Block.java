package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hashblocks")
public class Block {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "hashdata", columnDefinition = "VARCHAR(255)")
    private String hash; 

    @Column(name = "parenthash", columnDefinition = "VARCHAR(255)")
    private String parentHash; 

    @Column(name = "captiondata", columnDefinition = "VARCHAR(255)", nullable = true)
    private String data;

    Block() {}

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
