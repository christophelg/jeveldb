package com.github.christophelg.jeveldb;

/**
 * From: https://github.com/google/leveldb/blob/master/include/leveldb/filter_policy.h
 *
 * Created by Christophe on 27/12/2015.
 */
public interface FilterPolicy {

  // Return the name of this policy. Note that if the filter encoding
  // changes in an incompatible way, the name returned by this method
  // must be changed. Otherwise, old incompatible filters may be
  // passed to methods of this type.
  String name();

  // keys[0,n-1] contains a list of keys (potentially with duplicates)
  // that are ordered according to the user supplied comparator.
  // Append a filter that summarizes keys[0,n-1] to *filter.
  //
  // Warning: do not change the initial contents of *filter. Instead,
  // append the newly constructed filter to *filter.
  // Formelly known as:
  // virtual void CreateFilter(const Slice* keys, int n, std::string* dst)
  byte[] AppendKeysToFilter(byte[][] keys, byte[] filter);

  // "filter" contains the data appended by a preceding call to
  // CreateFilter() on this class. This method must return true if
  // the key was in the list of keys passed to CreateFilter().
  // This method may return true or false if the key was not on the
  // list, but it should aim to return false with a high probability.
  boolean keyMayMatch(byte[] key, byte[] filter);
}
