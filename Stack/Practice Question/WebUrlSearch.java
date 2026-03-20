package com.linkedlist;

import java.util.Stack;

public class WebUrlSearch {

    private Stack<String> backStack;
    private Stack<String> forwardStack;
    private String currentPage;

    public WebUrlSearch(String homepage) {
        backStack = new Stack<>();
        forwardStack = new Stack<>();
        currentPage = homepage;
    }

    // Visit new page
    public void visit(String url) {
        backStack.push(currentPage);
        currentPage = url;
        forwardStack.clear();
    }

    // Go back
    public void back() {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentPage);
            currentPage = backStack.pop();
        } else {
            System.out.println("No page to go back");
        }
    }

    // Go forward
    public void forward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(currentPage);
            currentPage = forwardStack.pop();
        } else {
            System.out.println("No page to go forward");
        }
    }

    // Display current page
    public void display() {
        System.out.println("Current Page: " + currentPage);
    }

    public static void main(String[] args) {

    	WebUrlSearch browser = new WebUrlSearch("google.com");

        browser.visit("youtube.com");
        browser.visit("github.com");
        browser.display();   // github

        browser.back();
        browser.display();   // youtube

        browser.back();
        browser.display();   // google

        browser.forward();
        browser.display();   // youtube

        browser.visit("leetcode.com");
        browser.display();   // leetcode

        browser.forward();   // no forward
    }
}