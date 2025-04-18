package com.rondus.taxtracker.service;

import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class BlockchainService {

    private final List<String> ledger = new ArrayList<>();

    /**
     * Stamps a record onto the simulated blockchain using SHA-256 hashing.
     * @param record The object to hash.
     * @return The generated hash.
     * @throws NoSuchAlgorithmException if SHA-256 is not available.
     */
    public String stampRecord(Object record) throws NoSuchAlgorithmException {
        String data = record.toString() + Instant.now().toString();
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(data.getBytes(StandardCharsets.UTF_8));
        String hashHex = Hex.encodeHexString(hash);
        ledger.add(hashHex);
        return hashHex;
    }

    /**
     * Simulates blockchain verification by returning a UUID (for demo/testing).
     * @param record The object to verify.
     * @return A simulated blockchain transaction ID.
     */
    public String verifyTransaction(Object record) {
        return UUID.randomUUID().toString(); // Placeholder for real blockchain verification
    }

    /**
     * Returns an immutable view of the ledger.
     * @return The blockchain ledger as an unmodifiable list.
     */
    public List<String> getLedger() {
        return Collections.unmodifiableList(ledger);
    }
}

