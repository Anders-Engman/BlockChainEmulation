// package com.controller;

// import java.net.URI;
 
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
 
// import com.dao.BlockDAO;
// import com.model.Block;
// import com.model.Blocks;
 
// @RestController
// @RequestMapping(path = "/blocks")
// public class BlockController 
// {
//     @Autowired
//     private BlockDAO blockDao;
     
//     @GetMapping(path="/getAll", produces = "application/json")
//     public Blocks getBlocks() 
//     {
//         return blockDao.getAllBlocks();
//     }
     
//     @PostMapping(path= "/createBlock", consumes = "application/json", produces = "application/json")
//     public ResponseEntity<Object> addBlock(@RequestBody Block block) 
//     {

//         block.setHash("new-hash");
         
//         blockDao.addBlock(block);
         
//         URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//                                     .path("/{hash}")
//                                     .buildAndExpand(block.getHash())
//                                     .toUri();
         
//         return ResponseEntity.created(location).build();
//     }
// }

package com.controller;

// import java.util.HashMap;

import java.util.List;
// import java.util.Map;

// import javax.validation.Valid;

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
