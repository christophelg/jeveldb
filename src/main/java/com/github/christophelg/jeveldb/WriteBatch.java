package com.github.christophelg.jeveldb;

/**
 * From:
 * https://github.com/google/leveldb/blob/master/include/leveldb/write_batch.h
 *
 * WriteBatch holds a collection of updates to apply atomically to a DB.
 //
 // The updates are applied in the order in which they are added
 // to the WriteBatch.  For example, the value of "key" will be "v3"
 // after the following batch is written:
 //
 //    batch.Put("key", "v1");
 //    batch.Delete("key");
 //    batch.Put("key", "v2");
 //    batch.Put("key", "v3");
 //
 // Multiple threads can invoke const methods on a WriteBatch without
 // external synchronization, but if any of the threads may call a
 // non-const method, all threads accessing the same WriteBatch must use
 // external synchronization.
 * Created by Christophe on 28/12/2015.
 */
public interface WriteBatch {

    // Store the mapping "key->value" in the database.
    void put(byte[] key, byte[] value);

    // If the database contains a mapping for "key", erase it.  Else do nothing.
    void delete(byte[] key);

    // Clear all updates buffered in this batch.
    void clear();
}
