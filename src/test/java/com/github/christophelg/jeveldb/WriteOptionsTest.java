package com.github.christophelg.jeveldb;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Christophe on 24/12/2015.
 */
public class WriteOptionsTest {
    @Test
    public void should_have_sync_options() throws Exception {
        WriteOptions wo1 = WriteOptions.build(true);

        assertTrue(wo1.shouldSync());
    }

    @Test
    public void should_get_same_default_write_options() throws Exception {
        WriteOptions wo1 = WriteOptions.build();
        WriteOptions wo2 = WriteOptions.build();

        assertTrue(wo1 == wo2);
    }

}
