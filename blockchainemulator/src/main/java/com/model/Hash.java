package com.java.model;

public class Hash {
    private byte[] hashCode;
    private boolean isMined;
    private int nonce;

    public Hash() {
        this.hashCode = null;
        this.isMined = false;
        this.nonce = 0;
    }

    public Hash(byte[] hashCode) {
        this.hashCode = hashCode;
        this.isMined = false;
        this.nonce = 0;
    }

    public void setHashCode(byte[] hashCode) {
        this.hashCode = hashCode;
    }

    public void setMiningStatus(boolean isMined) {
        this.isMined = isMined;
    }

    public void setNonce(int nonce) {
        this.nonce = nonce;
    }

    public byte[] getHashCode() {
        return this.hashCode;
    }

    public boolean getMiningStatus() {
        return this.isMined;
    }

    public int getNonce() {
        return this.nonce;
    }
}