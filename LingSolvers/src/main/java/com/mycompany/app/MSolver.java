package com.mycompany.app;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import com.mycompany.app.Morpheme;

public class MSolver extends Solver {
    public MSolver(DataSet d){
        super(d);
    }

    HashSet<Morpheme> solution = new HashSet<>();
    @Override
    public Set solve(){
        // solution=new HashSet<>();
        // String left, right;
        
        // for (int i=0;i<data.forms.length;i++){
        //     left = data.forms.get(i);
        //     for (int j=i;j<data.forms.length;j++){
        //         right = data.forms.get(j);
        //         if (minPair(left,right))
        //             // add compare to solution
        //             compare(left,right);
        //     }
        // }
        return solution;
    }
    // public void compare(Word a,Word b){
        
    // }
    public boolean minPair(Word a, Word b){
        //iteratively compare meanings
        int shared=0;
        int aKnown=0;
        int bKnown=0;
        for (int i=0;i<(a.meaning).size();i++){
            if (solution.contains(a.meaning.get(i))){
                aKnown++;
            }
        }
        for (int i=0;i<b.meaning.size();i++){
            if (solution.contains(b.meaning.get(i))){
                bKnown++;
            }
        }
        for (int i=0;i<a.meaning.size();i++){
            if(!solution.contains(a.meaning.get(i))){
                if (b.meaning.contains(a.meaning.get(i))){
                    shared++;
                }
            }
        }
        
        return Math.abs((a.meaning.size()-aKnown) - (b.meaning.size()-bKnown))<=1;
    }
}

