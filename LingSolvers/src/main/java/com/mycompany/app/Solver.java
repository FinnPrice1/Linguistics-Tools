package com.mycompany.app;

import java.util.Set;

public abstract class Solver{
    public DataSet data;

    public abstract Solution solve();


    public Solver(DataSet d){
        data=d;
    }
}