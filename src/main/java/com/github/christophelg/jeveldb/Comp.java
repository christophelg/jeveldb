package com.github.christophelg.jeveldb;

import java.util.Comparator;

/**
 * Created by Christophe on 24/12/2015.
 */
public interface Comp extends Comparator<byte[]>{

    String name();

    default byte[] findShortedSeparator(byte[] limit) {
        return limit;
    }

    default byte[] findShortSuccessor(byte[] key) {
        return key;
    }
}
