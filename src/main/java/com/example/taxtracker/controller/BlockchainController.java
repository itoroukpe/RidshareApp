// --- BlockchainController.java ---
package com.rondus.taxtracker.controller;

import com.rondus.taxtracker.service.BlockchainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/blockchain")
public class BlockchainController {

    @Autowired
    private BlockchainService blockchainService;

    @PostMapping("/stamp")
    public String stamp(@RequestBody Map<String, Object> body) throws NoSuchAlgorithmException {
        return blockchainService.stampRecord(body);
    }

    @PostMapping("/verify")
    public String verify(@RequestBody Map<String, Object> body) {
        return blockchainService.verifyTransaction(body);
    }

    @GetMapping("/ledger")
    public List<String> getLedger() {
        return blockchainService.getLedger();
    }
}
