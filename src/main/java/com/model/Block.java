package com.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

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

    @Column(name = "nonce", columnDefinition = "INT")
    private int Nonce;

    @Transient
    private boolean workProven;

    @Transient
    private int leadingZeros = 3;

    @Transient
    private String complexity = "000";

    @Column(name = "timestamp", columnDefinition = "BIGINT")
    private long timeStamp;

    @Column(name = "captiondata", columnDefinition = "VARCHAR(255)", nullable = true)
    private String data;

    Block() {}

    // Constructor for the block 
    public Block(String data, String parentHash) 
    { 
        this.data = data; 
        this.parentHash = parentHash;
        this.hash=calculateHash();
        this.Nonce = 0; 
        this.timeStamp = new Date().getTime();  

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

    public void setZeroes(int leadingZeroes){
      this.leadingZeros = leadingZeroes;
    }

    public int getZeroes(){
      return this.leadingZeros;
    }

    public boolean getWorkProven(){
      return workProven;
    }

    public int getNonce(){
      return Nonce;
    }

    public long getTimeStamp(){
      return timeStamp;
    }

    public void setComplexity(){
      String temp = "";
      for(int i=0;i<leadingZeros;i++){
        temp +="0";
      }
      complexity = temp;
    }
    public String getComplexity(){
      return complexity;
    }

    // Function to calculate the hash 
    public String calculateHash(){
      String calculatedHash = HashGenerator.generateHash(parentHash + timeStamp + Integer.toString(Nonce) + data);
      return calculatedHash;
     }
    //Function to mine the hash for proof of work 
    public String mineHash() 
    { 
      Nonce = 0;
      workProven = false;
      String minedHash = this.calculateHash();  
      while(!minedHash.substring(0,leadingZeros).equals(complexity)){
        minedHash = calculateHash();
        Nonce++;
      }
      if (minedHash.substring(0,leadingZeros).equals(complexity)){
          workProven = true;
      }

      return minedHash;
    } 
}
