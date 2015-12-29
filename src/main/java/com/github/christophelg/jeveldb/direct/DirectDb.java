package com.github.christophelg.jeveldb.direct;

import java.io.IOException;

import com.github.christophelg.jeveldb.DB;
import com.github.christophelg.jeveldb.Iter;
import com.github.christophelg.jeveldb.Options;
import com.github.christophelg.jeveldb.ReadOptions;
import com.github.christophelg.jeveldb.Snapshot;
import com.github.christophelg.jeveldb.WriteBatch;
import com.github.christophelg.jeveldb.WriteOptions;

/**
 * Created by Christophe on 28/12/2015.
 */
public class DirectDb implements DB {
  public DirectDb(Options options, String name) {}

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
  public Iter iterator(ReadOptions ro) {
    return new Iter() {

      @Override
      public void close() throws Exception {
        // TODO Auto-generated method stub

      }

      @Override
      public boolean isValid() {
        // TODO Auto-generated method stub
        return false;
      }

      @Override
      public void seekToFirst() {
        // TODO Auto-generated method stub

      }

      @Override
      public void seekToLast() {
        // TODO Auto-generated method stub

      }

      @Override
      public void seek(byte[] target) {
        // TODO Auto-generated method stub

      }

      @Override
      public void next() {
        // TODO Auto-generated method stub

      }

      @Override
      public void prev() {
        // TODO Auto-generated method stub

      }

      @Override
      public byte[] key() {
        // TODO Auto-generated method stub
        return null;
      }

      @Override
      public byte[] value() {
        // TODO Auto-generated method stub
        return null;
      }

    };
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

  @Override
  public WriteBatch newWriteBatch() {
    return new WriteBatch() {

      @Override
      public void put(byte[] key, byte[] value) {
        // TODO Auto-generated method stub

      }

      @Override
      public void delete(byte[] key) {
        // TODO Auto-generated method stub

      }

      @Override
      public void clear() {
        // TODO Auto-generated method stub

      }

    };
  }
}
