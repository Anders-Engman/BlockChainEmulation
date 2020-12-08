package com.controller;

import java.util.List;

import javax.validation.Valid;

import com.model.Block;
import com.repository.BlockRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/load-blocks")
    public List <Block> getAllBlocks() {
        return blockRepository.findAll();
    }

    @PostMapping("/add-block")
    public Block createBlock(@RequestBody Block block) {
        block.setHash(block.calculateHash());
        return blockRepository.save(block);
    }

    // @PutMapping("/update-block/{id}")
    public ResponseEntity <Block> updateBlock(@PathVariable(value = "id") long id,
        @Valid @RequestBody Block blockDetails) throws ResourceNotFoundException {
        Block block = blockRepository.findById(blockDetails.getId())
            .orElseThrow(() -> new ResourceNotFoundException("Block not found for id #" + blockDetails.getId()));

        block.setHash(blockDetails.getHash());
        block.setParentHash(blockDetails.getParentHash());
        block.setData(blockDetails.getData());
        block.setWorkProven(blockDetails.getWorkProven());

        final Block updatedBlock = blockRepository.save(block);
        return ResponseEntity.ok(updatedBlock);
    }

    @PutMapping("/mine-block/{id}")
    public ResponseEntity <Block> mineBlock(@PathVariable(value = "id") long id,
        @Valid @RequestBody Block blockDetails) throws ResourceNotFoundException {

        Block block = blockRepository.findById(blockDetails.getId())
            .orElseThrow(() -> new ResourceNotFoundException("Block not found for id #" + blockDetails.getId()));

        String initialHash = block.getHash();

        block.setHash(blockDetails.mineHash());
        block.setWorkProven(true);
        // block.setNonce(blockDetails.getNonce());

        final Block minedBlock = blockRepository.save(block);

        List<Block> allBlocks = blockRepository.findAll();

        int targetBlockIndex = findBlockByTimeStamp(allBlocks, minedBlock);

        if (determineIfBlockHasChildBlock(allBlocks, initialHash)) {
            updateChildBlocks(allBlocks, targetBlockIndex);
        } else {
            return ResponseEntity.ok(minedBlock);
        }

        return ResponseEntity.ok(minedBlock);
    }

    @PutMapping("/chain-update/{id}")
    public ResponseEntity <Block> updateChain(@PathVariable(value = "id") long id,
         @Valid @RequestBody Block targBlock, String data) throws ResourceNotFoundException {

            List<Block> allBlocks = blockRepository.findAll();

            int targetBlockIndex = findBlockByTimeStamp(allBlocks, targBlock);

            targBlock.setData(data);

            String initialHash = targBlock.getHash();

            targBlock.setHash(targBlock.calculateHash());

            updateBlock(targBlock.getId(), targBlock);

                if (determineIfBlockHasChildBlock(allBlocks, initialHash)) {
                    updateChildBlocks(allBlocks, targetBlockIndex);
                } else {
                    return ResponseEntity.ok(targBlock);
                }

            return ResponseEntity.ok(targBlock);
        }

        private int findBlockByTimeStamp(List<Block> blockList, Block targBlock) {

            for (int i = 0; i < blockList.size(); i++) {
                if (blockList.get(i).getTimeStamp() == targBlock.getTimeStamp()) {
                    return i;
                }
            }
            return -1;
        }

        private boolean determineIfBlockHasChildBlock(List<Block> blockList, String initialHash) {

            for (Block block : blockList) {
                if (block.getParentHash().equals(initialHash)) {
                    return true;
                }
            }
            return false;
        }

        private void updateChildBlocks(List<Block> blockList, int newParentIndex) {
            Block changeBlock;

            for (int i = newParentIndex + 1; i < blockList.size(); i++) {
                changeBlock = blockList.get(i);

                changeBlock.setParentHash(blockList.get(i - 1).getHash());

                changeBlock.setHash(changeBlock.calculateHash());

                updateBlock(changeBlock.getId(), changeBlock);
            }
        }

}
