package com.controller;

import java.net.URI;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
 
import com.dao.BlockDAO;
import com.model.Block;
import com.model.Blocks;
 
@RestController
@RequestMapping(path = "/api")
public class BlockController 
{
    @Autowired
    private BlockDAO blockDao;
     
    @GetMapping(path="/blocks", produces = "application/json")
    public Blocks getBlocks() 
    {
        return blockDao.getAllBlocks();
    }
     
    @PostMapping(path= "/add-block", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addBlock(@RequestBody Block block) 
    {

        block.setHash("new-hash");
         
        blockDao.addBlock(block);
         
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{hash}")
                                    .buildAndExpand(block.getHash())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
}
