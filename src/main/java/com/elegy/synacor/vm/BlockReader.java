package com.elegy.synacor.vm;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.BitSet;

/**
 * Reads 16-bit little-endian values as a list of integers
 */
class BlockReader {

    int[] read(Path filePath) {
        try {
            byte[] rawBytes = Files.readAllBytes(filePath);
            return read(rawBytes);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read file at " + filePath, e);
        }
    }

    int[] read(byte[] rawBytes) {
        int[] result = new int[rawBytes.length / 2];
        byte[] buffer = new byte[2];
        int index = 0;
        for (int i = 0; i < rawBytes.length; i += 2) {
            buffer[0] = rawBytes[i];
            buffer[1] = rawBytes[i + 1];
            result[index++] = parseInt(buffer);
        }
        return result;
    }

    /**
     * Converts a two-byte array into an integer value
     */
    private static int parseInt(byte[] buffer) {
        BitSet bitSet = BitSet.valueOf(buffer);
        if (bitSet.isEmpty()) {
            return 0;
        }
        return (int) bitSet.toLongArray()[0];
    }
}
