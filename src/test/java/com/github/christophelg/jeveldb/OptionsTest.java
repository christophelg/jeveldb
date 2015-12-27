package com.github.christophelg.jeveldb;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Christophe on 24/12/2015.
 */
public class OptionsTest {

    @Test
    public void check_all_default_values() throws Exception {
        Options o = new Options();

        assertEquals("Incorrect default block size", 4*1024, o.getBlockSize());
    }

}
