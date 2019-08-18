package com.nirvanaapp.sourcekode.fresco;

import java.util.ArrayList;
import java.util.List;
public class Root
{
    private int total;

    private int totalHits;

    private List<Hits> hits;

    public void setTotal(int total){
        this.total = total;
    }
    public int getTotal(){
        return this.total;
    }
    public void setTotalHits(int totalHits){
        this.totalHits = totalHits;
    }
    public int getTotalHits(){
        return this.totalHits;
    }
    public void setHits(List<Hits> hits){
        this.hits = hits;
    }
    public List<Hits> getHits(){
        return this.hits;
    }
}
