package com.mycompany.app;
import java.util.ArrayList;

public class Word {

    public String form;

    public ArrayList<String> meaning;

    public ArrayList getMeaning(){
        return meaning;
    }
    public Word(String text, String[] mean){
        form=text;
        meaning = new ArrayList<>();
        for (int i=0;i<mean.length;i++){
            meaning.add(mean[i]);
        }
    }

}