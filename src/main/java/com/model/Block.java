package com.model;

public class Block { 
 
    private String hash; 
    private String parentHash; 
    private String data; 
    private int Nonce;
    private boolean workProven;
    private HashGenerator hashGenerator;
    private int leadingZeros = 0;
    private String complexity = "0";
  
    // Constructor for the block 
    public Block(String data, 
                 String parentHash) 
    { 
        this.data = data; 
        this.parentHash = parentHash; 
        this.Nonce = 0; 
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
  
    // Function to calculate the hash 
    public String calculateHash(){
      String calculatedHash = hashGenerator.generateHash(parentHash + Integer.toString(Nonce) + data);
      return calculatedHash;
     }
    //Function to mine the hash for proof of work 
    public String mineHash() 
    { 
      String minedHash;  
      do{ 
        minedHash = calculateHash();

        if (minedHash.substring(0,leadingZeros).equals(complexity)){
          workProven = true;
        }

        else {
          Nonce++;
          if(Nonce == 10000000) break;
        }

      } while (workProven == false);

      return minedHash;
    } 
}
