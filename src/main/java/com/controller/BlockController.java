package com.controller;

import java.util.List;

import javax.validation.Valid;

import com.model.Block;
import com.repository.BlockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BlockController {

    @Autowired
    private BlockRepository blockRepository;

    BlockController(BlockRepository blockRepository) {
        this.blockRepository = blockRepository;
    }

    @GetMapping("/blocks")
    public List <Block> getAllBlocks() {
        return blockRepository.findAll();
    }

    @PostMapping("/blocks")
    public Block createBlock(@RequestBody Block block) {
        return blockRepository.save(block);
    }

    @PutMapping("/blocks")
    public ResponseEntity <Block> updateBlock(@PathVariable(value = "hash") String hash,
        @Valid @RequestBody Block blockDetails) throws ResourceNotFoundException {
        Block block = blockRepository.findByHash(hash)
        // TODO: Must finish writing proprietary "findByHash" method
        // Could use the repository.findall function and then finding the matching block
        // within the resultant list
            .orElseThrow(() -> new ResourceNotFoundException("Block not found for this id :: " + BlockId));

        block.setHash(blockDetails.getHash());
        block.setParentHash(blockDetails.getParentHash());
        block.setData(blockDetails.getData());
        block.setNonce(blockDetails.getNonce());
        block.setWorkProven(blockDetails.getWorkProven());
        block.setZeroes(blockDetails.getZeroes());
        block.setComplexity(Integer.parseInt(blockDetails.getComplexity()));
        block.setTimeStamp(blockDetails.getTimeStamp());

        final Block updatedBlock = blockRepository.save(block);
        return ResponseEntity.ok(updatedBlock);
    }

}
