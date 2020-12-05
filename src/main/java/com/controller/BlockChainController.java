package com.controller;

import java.util.List;

import com.service.BlockChainService;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Block;

@Controller
@RequestMapping("/api/")
public class BlockChainController {

    BlockChainService blockChainService;

    @RequestMapping(value = "/api/Blocks/All/", method = RequestMethod.GET)
    public ResponseEntity<?> retrieveFullBlockList() {
        List<Block> blocks = blockChainService.findAllBlocks();
        return ResponseEntity.ok(blocks);
    }

    @RequestMapping(path = "/api/Blocks/{hash}", method = RequestMethod.GET)
    public ResponseEntity<?> getBlockByHash(@PathVariable("hash") String hash) {
        Block targetBlock = blockChainService.findBlockByHash(hash);
        return ResponseEntity.ok(targetBlock);
    }

    @RequestMapping(path = "/api/Blocks/Save/", method = RequestMethod.POST)
    public ResponseEntity<?> saveBlock(@RequestBody Block block) {
        Block resBlock = blockChainService.saveBlock(block);
        return ResponseEntity.ok(resBlock);
    }

    @RequestMapping(path = "/api/Blocks/Delete", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteBlock(@RequestBody Block block) {
        Block delBlock = blockChainService.deleteBlock(block);
        return ResponseEntity.ok(delBlock);
    }
}