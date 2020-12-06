package com.controller;

import java.util.List;

//import com.service.BlockChainService;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model.Block;
import com.repository.BlockChainRepository;

@RestController
// @RequestMapping("/api/")
public class BlockChainController {

    @Autowired
    BlockChainRepository blockChainRepository;

    @GetMapping(path = "/blocks/all", produces = "application/json")
    public List<Block>  retrieveFullBlockList() {
        return blockChainRepository.findAllBlocks();
    }

    // @GetMapping(path = "/blocks/{hash}")
    // public ResponseEntity<?> getBlockByHash(@PathVariable("hash") String hash) {
    //     Block targetBlock = blockChainService.findBlockByHash(hash);
    //     return ResponseEntity.ok(targetBlock);
    // }

    // @PostMapping(path = "/blocks/save")
    // public ResponseEntity<?> saveBlock(@RequestBody Block block) {
    //     Block resBlock = blockChainService.saveBlock(block);
    //     return ResponseEntity.ok(resBlock);
    // }

    // @PutMapping(path = "/blocks/update/{hash}")
    // public ResponseEntity<?> updateBlockByHash(@PathVariable("hash") String hash) {
    //     Block updateBlockByHash = blockChainService.updateBlockByHash(hash);
    //     return ResponseEntity.ok(updateBlockByHash);
    // }
}