package com.github.christophelg.jeveldb;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by Christophe on 24/12/2015.
 */
public class ReadOptionsTest {

    @Test
    public void should_get_same_default_read_options() throws Exception {
        ReadOptions ro1 = ReadOptions.build();
        ReadOptions ro2 = ReadOptions.build();

        assertTrue(ro1 == ro2);
    }

}
