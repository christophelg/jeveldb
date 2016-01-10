package com.github.christophelg.jeveldb.direct.util;

import com.github.christophelg.jeveldb.FilterPolicy;

/**
 * From: https://github.com/google/leveldb/blob/master/util/bloom.cc
 * 
 * @author Christophe
 *
 */
public class BloomFilterPolicy implements FilterPolicy {

  private int mBitPerKey, k;

  public BloomFilterPolicy(int bitPerKey) {
    mBitPerKey = bitPerKey;
    k = (int) (mBitPerKey * 0.69);
    if (k < 1) {
      k = 1;
    }
    if (k > 30) {
      k = 30;
    }
  }

  @Override
  public String name() {
    return "leveldb.BuiltinBloomFilter2";
  }

  @Override
  public byte[] AppendKeysToFilter(byte[][] keys, byte[] filter) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean keyMayMatch(byte[] key, byte[] bloom_filter) {

    int len = bloom_filter.length;
    if (len < 2) {
      return false;
    }
    // so that we can use the same variable names as in the C++ code
    byte[] array = bloom_filter;

    int bits = (len - 1) * 8;
    // Use the encoded k so that we can read filters generated by
    // bloom filters created using different parameters.
    int k = array[len - 1];
    if (k > 30) {
      // Reserved for potentially new encodings for short bloom filters.
      // Consider it a match.
      return true;
    }

    int h = hash(key);
    int delta = (h >> 17) | (h << 15); // Rotate right 17 bits
    for (int j = 0; j < k; ++j) {
      int bitpos = h % bits;
      if ((array[bitpos / 8] & 1 << (bitpos % 8)) == 0) {
        return false;
      }
      h += delta;
    }
    return true;
  }

  private static int hash(byte[] data) {
    return Hash.hash(data, 0xbc9f1d34);
  }
}