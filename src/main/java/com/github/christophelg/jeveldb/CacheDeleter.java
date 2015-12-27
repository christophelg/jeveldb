package com.github.christophelg.jeveldb;

/**
 * From:
 * https://github.com/google/leveldb/blob/master/include/leveldb/cache.h
 *
 * Represent the concept:
 * void (*deleter)(const Slice& key, void* value)
 *
 * Created by Christophe on 27/12/2015.
 */
@FunctionalInterface
public interface CacheDeleter {
    void delete(byte[] key, byte[] value);
}
