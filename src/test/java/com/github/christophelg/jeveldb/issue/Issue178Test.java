package com.github.christophelg.jeveldb.issue;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.github.christophelg.jeveldb.CompressionType;
import com.github.christophelg.jeveldb.DB;
import com.github.christophelg.jeveldb.Iter;
import com.github.christophelg.jeveldb.Options;
import com.github.christophelg.jeveldb.ReadOptions;
import com.github.christophelg.jeveldb.WriteBatch;
import com.github.christophelg.jeveldb.WriteOptions;
import com.google.common.io.Files;

/**
 * Created by Christophe on 24/12/2015.
 */
public class Issue178Test {

  public static int kNumKeys = 11; // 1100000;

  public static String key1(int i) {
    return String.format("my_key_%1d", i);
  }

  public static String key2(int i) {
    return key1(i) + "_xxx";
  }

  @Test
  public void tnr_issue_178() throws Exception {
    File dbPath = Files.createTempDir();
    dbPath.deleteOnExit();

    System.out.printf(dbPath.getAbsolutePath());
    // Open database. Disable compression since it affects the creation
    // of layers and the code below is trying to test against a very
    // specific scenario.
    Options o = new Options();
    o.setCreateIfMissing(true);
    o.setCompression(CompressionType.NO_COMPRESSION);
    try (DB db = DB.open(o, dbPath.getAbsolutePath())) {

      // create first key range
      WriteBatch batch = db.newWriteBatch();
      for (int i = 0; i < kNumKeys; i++) {
        batch.put(key1(i).getBytes(), "value for range 1 key".getBytes());
      }
      WriteOptions wo = WriteOptions.build();
      db.write(wo, batch);

      // create second key range
      batch.clear();
      for (int i = 0; i < kNumKeys; i++) {
        batch.put(key2(i).getBytes(), "value for range 2 key".getBytes());
      }
      db.write(wo, batch);

      // delete second key range
      batch.clear();
      for (int i = 0; i < kNumKeys; i++) {
        batch.delete(key2(i).getBytes());
      }
      db.write(wo, batch);

      // compact database
      String startKey = key1(0), endKey = key1(kNumKeys - 1);

      // commenting out the line below causes the example to work correctly
      db.compactRange(startKey.getBytes(), endKey.getBytes());

      // count the keys
      ReadOptions ro = ReadOptions.build();
      int keyCount = 0;
      try (Iter iter = db.iterator(ro)) {
        for (iter.seekToFirst(); iter.isValid(); iter.next()) {
          ++keyCount;
        }
      }
      assertEquals("BUG", keyCount, kNumKeys);
    }
  }

  @Test
  public void check_key_format() {
    String key = key1(12);
    assertEquals("incorrect key", "my_key_12", key);
  }

  @Test
  public void check_test_dir() throws IOException {
    File dbPath = Files.createTempDir();
    System.out.printf(dbPath.getAbsolutePath());
    dbPath.deleteOnExit();
  }
}
