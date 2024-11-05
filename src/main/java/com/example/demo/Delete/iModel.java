package com.example.demo.Delete;

import com.example.demo.Delete.Filter;

import java.util.ArrayList;
import java.util.Stack;

public class iModel {
    
    // Stack of ArrayLists of Filter objects
    private Stack<ArrayList<Filter>> stack;

    // push
    public void push (ArrayList<Filter> filter) {
        stack.push(filter);
    }

    // pop
    public ArrayList<Filter> pop() {
        return stack.pop();
    }

    // peek
    public ArrayList<Filter> peek() {
        return stack.peek();
    }
    
    // view
    public Stack<ArrayList<Filter>> view() {
        return stack;
    }
    
    // current view shown
    // widgets shown on that view
}
