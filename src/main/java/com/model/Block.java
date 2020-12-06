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
@Table(name="blocks")
public class Block { 
 
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    @Column
    private String hash; 

    @Column
    private String parentHash; 

    @Column
    private String data; 

    @Column
    private int Nonce;

    @Column
    private boolean workProven;

    @Transient
    private HashGenerator hashGenerator;

    @Transient
    private int leadingZeros = 3;

    @Transient
    private String complexity = "000";

    @Column
    private long timeStamp;
  
    Block() {}

    // Constructor for the block 
    public Block(String data, 
                 String parentHash) 
    { 
        this.data = data; 
        this.parentHash = parentHash; 
        this.Nonce = 0; 
        this.timeStamp = new Date().getTime(); 
        this.hash = calculateHash(); 
    }

    public void setHash(String hash) {
      this.hash = hash;
    }

    public void setParentHash(String parentHash) {
      this.parentHash = parentHash;
    }

    public String getHash() {
      return this.hash;
    }

    public String getParentHash() {
      return this.parentHash;
    }

    public void setZeroes(int leadingZeroes){
      this.leadingZeros = leadingZeroes;
    }

    public int getZeroes(){
      return leadingZeros;
    }

    public boolean getWorkProven(){
      return workProven;
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
      String calculatedHash = hashGenerator.generateHash(parentHash + timeStamp + Integer.toString(Nonce) + data);
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
