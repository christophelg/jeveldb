package com.github.christophelg.jeveldb.direct;

import com.github.christophelg.jeveldb.*;

import java.io.IOException;

/**
 * Created by Christophe on 28/12/2015.
 */
public class DirectDb implements DB {
    public DirectDb(Options options, String name) {
    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public void put(WriteOptions wo, byte[] key, byte[] value) throws IOException {

    }

    @Override
    public void delete(WriteOptions wo, byte[] key) throws IOException {

    }

    @Override
    public void write(WriteOptions wo, WriteBatch batch) throws IOException {

    }

    @Override
    public byte[] get(ReadOptions ro, byte[] key) throws IOException {
        return new byte[0];
    }

    @Override
    public Snapshot getSnapshot() throws IOException {
        return null;
    }

    @Override
    public void releaseSnapshot() throws IOException {

    }

    @Override
    public String getProperty(String name) {
        return null;
    }

    @Override
    public void compactRange(byte[] begin, byte[] end) {

    }
}
