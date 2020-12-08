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
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "hashdata", columnDefinition = "VARCHAR(255)")
    private String hash; 

    @Column(name = "parenthash", columnDefinition = "VARCHAR(255)")
    private String parentHash; 

    @Column(name = "captiondata", columnDefinition = "VARCHAR(255)", nullable = true)
    private String data;

    @Column(name = "nonce", columnDefinition = "INT")
    private int nonce;

    @Column(name = "workproven", columnDefinition = "BIT")
    private boolean workProven;

    @Transient
    private int leadingZeros = 3;

    @Transient
    private String complexity = "000";

    @Column(name = "blocktime", columnDefinition = "LONG")
    private long timeStamp;

    Block() {}

    public Block(String data, String parentHash) 
    { 
        this.data = data; 
        this.parentHash = parentHash;
        this.hash=calculateHash();
        this.nonce = 0; 
        this.timeStamp = new Date().getTime();  
    }

    public Block(String data, String parentHash, String hash) 
    { 
        this.data = data; 
        this.parentHash = parentHash;
        this.hash=hash;
        this.nonce = 0; 
        this.timeStamp = new Date().getTime();  
    }
 
    public long getId() {
      return this.id;
    }

    //Getters and setters
    public void setHash(String hash) {
      this.hash = hash;
    }

    public String getHash() {
      return this.hash;
    }

    public void setParentHash(String parentHash) {
      this.parentHash = parentHash;
    }

    public String getParentHash() {
      return this.parentHash;
    }

    public void setData(String data) {
      this.data = data;
    }

    public void setNonce(int nonce) {
      this.nonce = nonce;
    }

    public int getNonce(){
      return nonce;
    }

    public void setWorkProven(boolean workProven) {
      this.workProven = workProven;
    }

    public boolean getWorkProven(){
      return workProven;
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

    public void setTimeStamp(long timeStamp) {
      this.timeStamp = timeStamp;
    }

    public long getTimeStamp(){
      return timeStamp;
    }

    public void setComplexity(int leadingZeroes){
      String temp = "";

      for (int i=0 ; i<leadingZeros ; i++) {
        temp +="0";
      }

      complexity = temp;
    }
    public String getComplexity(){
      return complexity;
    }

    // Function to calculate the hash 
    public String calculateHash(){
      String calculatedHash = HashGenerator.generateHash(parentHash + timeStamp + Integer.toString(nonce) + data);
      return calculatedHash;
     }
    //Function to mine the hash for proof of work 
    public String mineHash() 
    { 
      int tempNonce = 0;
      workProven = false;
      String minedHash = this.calculateHash();  

      while (!minedHash.substring(0,leadingZeros).equals(complexity)) 
      {
        minedHash = calculateHash();
        tempNonce++;
      }
      if (minedHash.substring(0,leadingZeros).equals(complexity)){
          workProven = true;
      }

      this.nonce = tempNonce;

      return minedHash;
    } 
}
