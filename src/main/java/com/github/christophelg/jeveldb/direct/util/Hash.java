package com.github.christophelg.jeveldb.direct.util;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

public class Hash {

  public static int hash(byte[] data, int seed) {
    HashFunction murmur3_32 = Hashing.murmur3_32(seed);
    return murmur3_32.hashBytes(data).asInt();
  }
}
