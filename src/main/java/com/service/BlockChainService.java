// package com.service;

// import com.repository.BlockChainRepository;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
// import org.springframework.transaction.annotation.Transactional;

// import java.util.List;

// import com.model.Block;

// @Service
// public class BlockChainService {
 
//     private BlockChainRepository blockChainRepository;

//     @Autowired
//     public BlockChainService(BlockChainRepository blockChainRepository) {
//         this.blockChainRepository = blockChainRepository;
//     }

//     @Transactional
//     public List<Block> findAllBlocks() {
//         return blockChainRepository.findAllBlocks();
//     }

//     @Transactional
//     public Block findBlockByHash(String hash) {
//         return blockChainRepository.findBlockByHash(hash);
//     }

//     @Transactional
//     public Block saveBlock(Block block) {
//         return blockChainRepository.saveBlock(block);
//     }

//     // @Transactional
//     // public Block deleteBlock(Block block) {
//     //     return blockChainRepository.updateBlockByHash(block);
//     // }
// }
