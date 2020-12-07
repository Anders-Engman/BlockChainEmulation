package com.controller;

import java.util.List;

import javax.validation.Valid;

import com.google.common.base.Optional;
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

    @GetMapping("/blocks/{id}")
    public Block getBlockById(@PathVariable(value = "id") long id) throws ResourceNotFoundException {
        String idString = Long.toString(id);
        Block returnBlock = blockRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Block not found with id #" + idString));
        return returnBlock;
    }

    @PostMapping("/blocks")
    public Block createBlock(@RequestBody Block block) {
        return blockRepository.save(block);
    }

    @PutMapping("/blocks/{id}")
    public ResponseEntity <Block> updateBlock(@PathVariable(value = "id") long id,
        @Valid @RequestBody Block blockDetails) throws ResourceNotFoundException {
        Block block = blockRepository.findById(blockDetails.getId())
            .orElseThrow(() -> new ResourceNotFoundException("Block not found for id #" + blockDetails.getId()));

        block.setHash(blockDetails.getHash());
        block.setParentHash(blockDetails.getParentHash());
        block.setData(blockDetails.getData());
        block.setNonce(blockDetails.getNonce());
        block.setWorkProven(blockDetails.getWorkProven());
        block.setZeroes(blockDetails.getZeroes());
        block.setComplexity(Integer.parseInt(blockDetails.getComplexity()));
        // block.setTimeStamp(blockDetails.getTimeStamp());

        final Block updatedBlock = blockRepository.save(block);
        return ResponseEntity.ok(updatedBlock);
    }

    // @PutMapping("/blocks/chainUpdate/{id}")
    //     // Method Signature (Block targBlock)
    // public ResponseEntity <Block> updateChain(@PathVariable(value = "id") long id,
    //      @Valid @RequestBody Block targBlock) throws ResourceNotFoundException {
    //     // 1. Basically I have to pull a list of the blocks
    //     //     1.1. Use Repo FindAll to Get An Array
    //     // 2. Detect where in the chain the change is occurring and update
    //     //     2.1. Find the block via hash
    //     //     2.2. Process the new Hash and update the targetBlock object
    //     //     2.3. Take hash from target block object, update parent hash in child object
    //     //         2.3.1. process new hash for child block object
    //     //         2.3.2. This will have to occur for every subsequent element in the array
    //     //             2.3.2.1. This means taking the index of the targBlock and looping through
    //     //             the indexes until the end of the array
                
    //     // 3. Update each block subsequently
    //     //     3.1. Take hash from target block object, update parent hash in child object
    //     //         3.1.1. process new hash for child block object
    //     //         3.1.2. This will have to occur for every subsequent element in the array
    //     //             3.1.2.1. This means taking the index of the targBlock and looping through
    //     //             the indexes until the end of the array
    //     // 4. Run a Put Request for each entity (update operations)
    //     //     4.1. Once all objects are updated, use enhanced for loop to put each one into
    //     //     the db based on timestamp
    //      }

}
