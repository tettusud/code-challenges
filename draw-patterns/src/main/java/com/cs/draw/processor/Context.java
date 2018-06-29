package com.cs.draw.processor;

public class Context {

    private String[][] dataCtx=null;

    public String[][] getCtx(){
        return dataCtx;
    }

    protected void initCtx(int x,int y){
        dataCtx=new String[x][y];
    }

}
