package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.mycompany.app.DataSet;
import com.mycompany.app.MSolver;
import com.mycompany.app.Word;

public class WordTest {

    String fishs[] = {"fish",".sg"};
    String dogs[] = {"dog",".pl"};
    String cats[]={"cat",".pl"};
    Word fish = new Word("fish",fishs);
    Word dog = new Word("dogs",dogs);
    Word cat = new Word("cat",cats);
    Word[] points= {};
    MSolver solve = new MSolver(new DataSet(points));

    @Test
    public void testMinPair(){
        assertTrue(solve.minPair(dog,cat));
        assertFalse(solve.minPair(dog,fish));
    }
    // add more tests for size difference, and known elements

}
