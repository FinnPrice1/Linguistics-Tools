package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.*;

import java.beans.Transient;

import org.junit.jupiter.api.Test;

import com.mycompany.app.DataSet;
import com.mycompany.app.MSolver;
import com.mycompany.app.Word;
import com.mycompany.app.Morpheme;

public class WordTest {

    Word[] points = {};
    MSolver solve = new MSolver(new DataSet(points));

    @Test
    public void testMinPairEqual(){
        String fishs[] = {"fish",".sg"};
        String dogs[] = {"dog",".pl"};
        String cats[]={"cat",".pl"};
        Word fish = new Word("fish",fishs);
        Word dog = new Word("dogs",dogs);
        Word cat = new Word("cat",cats);
        
        assertTrue(solve.minPair(dog,cat));
        assertFalse(solve.minPair(dog,fish));
    }
    
    @Test
    public void testMinPairUneqaul(){
        String dogs[] = {"dog",".pl"};
        String dogGen[]={"dog",".pl",".gen"};
        String fishs[] = {"fish",".sg"};

        Word dog = new Word("dogs",dogs);
        Word dogG = new Word("dogs'",dogGen);
        Word fish = new Word("fish",fishs);

        assertTrue(solve.minPair(dog,dogG));
        assertFalse(solve.minPair(dog,fish));
    }

    @Test
    public void testMinPairKnown(){
        Morpheme dog = new Morpheme("dog","dog");
        Morpheme cat = new Morpheme("cat","cat");
        Morpheme fish = new Morpheme("fish","fish");
        solve.addKnown(dog);
        solve.addKnown(cat);
        solve.addKnown(fish);
        
        String dogs[] = {"dog",".sg",".gen"};
        String cats[] = {"cat",".pl",".gen"};
        String fishs[] = {"fish",".bl",".gne"}; 

        Word fishG = new Word("fishblgne",fishs);
        Word dogG = new Word("dog's",dogs);
        Word catG = new Word("cats'",cats);

        assertTrue(solve.minPair(dogG,catG));   
        assertFalse(solve.minPair(fishG,catG));
        assertFalse(solve.minPair(fishG,dogG));
    }

    @Test
    public void testCompareEvenSize(){
        String cats[]={"cat",".pl"};
        String dogs[] = {"dog",".pl"};
        Word dog = new Word("dogs",dogs);
        Word cat = new Word("cat",cats);

        solve.compare(dog,cat);

        Solution answer = solve.solve();
        assertTrue(answer.contains("cat")!=-1);
        assertTrue(answer.contains("dog")!=-1);
    }
}
    // add more tests for size difference, and known elements


