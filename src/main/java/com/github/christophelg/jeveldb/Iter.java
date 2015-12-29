package com.github.christophelg.jeveldb;

/**
 * From:
 * https://github.com/google/leveldb/blob/master/include/leveldb/iterator.h
 *
 * An iterator yields a sequence of key/value pairs from a source.
 * The following class defines the interface.  Multiple implementations
 * are provided by this library.  In particular, iterators are provided
 * to access the contents of a Table or a DB.
 *
 * Multiple threads can invoke const methods on an Iterator without
 * external synchronization, but if any of the threads may call a
 * non-const method, all threads accessing the same Iterator must use
 * external synchronization.
 * Created by Christophe on 28/12/2015.
 */
public interface Iter extends AutoCloseable {

    // An iterator is either positioned at a key/value pair, or
    // not valid.  This method returns true iff the iterator is valid.
    boolean isValid();

    // Position at the first key in the source.  The iterator is Valid()
    // after this call iff the source is not empty.
    void seekToFirst();

    // Position at the last key in the source.  The iterator is
    // Valid() after this call iff the source is not empty.
    void seekToLast();

    // Position at the first key in the source that is at or past target.
    // The iterator is Valid() after this call iff the source contains
    // an entry that comes at or past target.
    void seek(byte[] target);

    // Moves to the next entry in the source.  After this call, Valid() is
    // true iff the iterator was not positioned at the last entry in the source.
    // REQUIRES: Valid()
    void next();

    // Moves to the previous entry in the source.  After this call, Valid() is
    // true iff the iterator was not positioned at the first entry in source.
    // REQUIRES: Valid()
    void prev();


    // Return the key for the current entry.  The underlying storage for
    // the returned slice is valid only until the next modification of
    // the iterator.
    // REQUIRES: Valid()
    byte[] key();

    // Return the value for the current entry.  The underlying storage for
    // the returned slice is valid only until the next modification of
    // the iterator.
    // REQUIRES: Valid()
    byte[] value();



}
