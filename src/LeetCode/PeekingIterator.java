package LeetCode;

import java.util.*;

//https://leetcode.com/problems/peeking-iterator/submissions/
public class PeekingIterator implements Iterator<Integer> {// 5 ms
    Iterator<Integer> iterator;
    Integer peekValued;
    boolean flag;
    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(!flag){
            peekValued = iterator.next();
            flag = true;
        }
        return peekValued;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(flag){
            flag=false;
            return peekValued;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        if(flag)
            return true;
        return iterator.hasNext();
    }
    public static void main(String[] args) {

    }
}