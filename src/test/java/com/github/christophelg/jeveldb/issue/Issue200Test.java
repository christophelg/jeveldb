package com.github.christophelg.jeveldb.issue;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

import com.github.christophelg.jeveldb.DB;
import com.github.christophelg.jeveldb.Iter;
import com.github.christophelg.jeveldb.Options;
import com.github.christophelg.jeveldb.ReadOptions;
import com.github.christophelg.jeveldb.WriteOptions;
import com.google.common.io.Files;

/**
 * Created by Christophe on 24/12/2015.
 */
public class Issue200Test {

  public static int kNumKeys = 11; // 1100000;

  public static String key1(int i) {
    return String.format("my_key_%1d", i);
  }

  public static String key2(int i) {
    return key1(i) + "_xxx";
  }

  @Test
  public void tnr_issue_200() throws Exception {
    File dbPath = Files.createTempDir();
    dbPath.deleteOnExit();

    System.out.printf(dbPath.getAbsolutePath());
    // Open database. Disable compression since it affects the creation
    // of layers and the code below is trying to test against a very
    // specific scenario.
    Options o = new Options();
    o.setCreateIfMissing(true);
    try (DB db = DB.open(o, dbPath.getAbsolutePath())) {

      WriteOptions wo = WriteOptions.build();
      db.put(wo, "1".getBytes(), "b".getBytes());
      db.put(wo, "2".getBytes(), "c".getBytes());
      db.put(wo, "3".getBytes(), "d".getBytes());
      db.put(wo, "4".getBytes(), "e".getBytes());
      db.put(wo, "5".getBytes(), "f".getBytes());

      // count the keys
      ReadOptions ro = ReadOptions.build();
      try (Iter iterator = db.iterator(ro)) {
        // Add an element that should not be reflected in the iterator.
        db.put(wo, "25".getBytes(), "cd".getBytes());
        iterator.seek("5".getBytes());
        assertArrayEquals("Initial seek failed", iterator.key(), "5".getBytes());
        iterator.prev();
        assertArrayEquals("First prev", iterator.key(), "4".getBytes());
        iterator.prev();
        assertArrayEquals("Second prev", iterator.key(), "3".getBytes());
        iterator.next();
        assertArrayEquals("First next", iterator.key(), "4".getBytes());
        iterator.next();
        assertArrayEquals("Second next", iterator.key(), "5".getBytes());
      }
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
