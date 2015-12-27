package com.github.christophelg.jeveldb;

/**
 * From:
 * https://github.com/google/leveldb/blob/master/include/leveldb/options.h
 *
 * DB contents are stored in a set of blocks, each of which holds a
 * sequence of key,value pairs.  Each block may be compressed before
 * being stored in a file.  The following enum describes which
 * compression method (if any) is used to compress a block.
 * NOTE: do not change the values of existing entries, as these are part of the persistent format on disk.
 *
 * Created by Christophe on 24/12/2015.
 */

public enum CompressionType {
    NO_COMPRESSION,
    SNAPPY
}
