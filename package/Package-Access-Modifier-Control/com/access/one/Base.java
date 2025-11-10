package com.access.one;
public class Base {
    public void publicMethod(){ System.out.println("publicMethod accessible"); }
    protected void protectedMethod(){ System.out.println("protectedMethod accessible"); }
    void defaultMethod(){ System.out.println("defaultMethod accessible"); }
    private void privateMethod(){ System.out.println("privateMethod accessible"); }
    public void callAll(){
        publicMethod();
        protectedMethod();
        defaultMethod();
        privateMethod();
    }
}
