# jeveldb
A port of leveldb in java

## Motivation

This is an exercise to catch up with the new features of Java 8.
If you want something that works, you should use the port:
https://github.com/dain/leveldb

## Requirements

* Built with Java 1.8
* Use idiomatic java constructs
* Only dependencies against guava, junit
* Try to follow a TDD approach

## Specs

* Have DB implements SortedMap<byte[], byte[]>
* No Slice, directly byte[]
* No specific Logger, use standard JUL Logger
* Don't expose Status, replaced with exceptions
* Don't expose Env

