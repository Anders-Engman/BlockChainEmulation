package com.controller;

import java.util.List;

import com.model.Block;
import com.repository.BlockRepository;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/hashblocks")
    public List <Block> getAllBlocks() {
        return blockRepository.findAll();
    }
}
