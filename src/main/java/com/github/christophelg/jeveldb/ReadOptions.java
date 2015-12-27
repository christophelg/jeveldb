package com.github.christophelg.jeveldb;

/**
 * From:
 * https://github.com/google/leveldb/blob/master/include/leveldb/options.h
 *
 * Options that control read operations
 * Created by Christophe on 24/12/2015.
 */

public class ReadOptions {
    // If true, all data read from underlying storage will be
    // verified against corresponding checksum.
    // Default: false
    private boolean verifyChecksum;

    // Should the data read for this iteration be cached in memory?
    // Callers may wish to set this field to false for bulk scans.
    // Default: true
    private boolean fillCache = true;

    // If "snapshot" is non-NULL, read as of the supplied snapshot
    // (which must belong to the DB that is being read and which must
    // not have been released).  If "snapshot" is NULL, use an implicit
    // snapshot of the state at the beginning of this read operation.
    // Default: NULL
    private Snapshot snapshot;

    private static ReadOptions DEFAULT_OPTIONS = new ReadOptions();

    public boolean isVerifyChecksum() {
        return verifyChecksum;
    }

    public boolean isFillCache() {
        return fillCache;
    }

    public Snapshot getSnapshot() {
        return snapshot;
    }

    public static ReadOptions build(Snapshot snap) {
        return new ReadOptions(snap);
    }

    public static ReadOptions build() {
        return DEFAULT_OPTIONS;
    }

    private ReadOptions() {    }

    private ReadOptions(Snapshot snap) {
        snapshot = snap;
    }

}
