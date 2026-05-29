package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.mycompany.app.DataSet;
import com.mycompany.app.MSolver;
import com.mycompany.app.Word;

public class WordTest {


    
    String dogs[] = {"dog",".pl"};
    String[] cats={"cat",".pl"};
    Word dog = new Word("dogs",dogs);
    Word cat = new Word("cat",cats);
    Word[] points= {};
    MSolver solve = new MSolver(new DataSet(points));

    @Test
    public void testMinPair(){
        System.out.println(solve.minPair(dog,cat));
    }
    

}
