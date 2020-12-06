package com.model;
import java.util.Date;

public class Block {
 
    private String hash; 
    private String parentHash; 
    private String data;
    private int Nonce;
    private boolean workProven;
    private int leadingZeros = 3;
    private String complexity = "000";
    private long timeStamp;


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
