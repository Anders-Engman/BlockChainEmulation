public class Block { 
 
    public String hash; 
    public String parentHash; 
    private String data; 
    private int Nonce;
    private boolean workProven;
    public int leadingZeros = 0;
    public String complexity = "0";
  
    // Constructor for the block 
    public Block(String data, 
                 String parentHash) 
    { 
        this.data = data; 
        this.parentHash = parentHash; 
        this.Nonce = 0; 
        this.hash = calculateHash(); 
    } 
  
    // Function to calculate the hash 
    public String calculateHash(){
      String calculatedHash = hashGenerator.generateHash(parentHash + Integer.toString(Nonce) + data);
      return calculatedHash;
     }
    //Function to mine the hash for proof of work 
    public String mineHash() 
    {  
      do{ 
        String minedHash = calculateHash();
        if(minedHash.substring(0,leadingZeros).equals(complexity)){
          workProven = true;
        }
        else{
          Nonce++;
         if(Nonce == 10000000) break;
        }
      }while (workProven = false);
      return minedHash;
    } 
}
