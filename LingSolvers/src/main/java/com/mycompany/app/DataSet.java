package com.mycompany.app;
import java.util.ArrayList;
import java.io.File;
public class DataSet {

    public ArrayList<Word> forms;

    public DataSet(File file){
        //TODO implement
    }

    public DataSet(Word[] points){
        forms = new ArrayList();
        for (int i=0;i<points.length;i++){
            forms.add(points[i]);
        }
    }

}