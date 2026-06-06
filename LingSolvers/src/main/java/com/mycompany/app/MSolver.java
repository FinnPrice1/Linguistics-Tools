package com.mycompany.app;

import java.util.ArrayList;
import com.mycompany.app.Morpheme;

public class MSolver extends Solver {
    public MSolver(DataSet d){
        super(d);
    }

    Solution solution = new Solution();
    @Override
    public Solution solve(){
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
    //TODO make this private later
    public void addKnown(Morpheme m){
        solution.add(m);
    }
    public void compare(Word a,Word b){
        
    }
    //TODO make private later
    public String getPrefix(char[] a, char[] b){
        String ret = "";
        for (int i=0;i<a.length&&i<b.length;i++){
            if (a[i]==b[i]){
                ret+=a[i];
            }
            else{
                break;
            }
        }
        return ret;
    }
    public String getSuffix(char[] a, char[] b){
        String ret = "";
        for (int i=a.length-1,j=b.length-1;i>=0&&j>=0;i--,j--){
            if (a[i]==b[j]){
                ret+=a[i];
            }
            else{
                break;
            }
        }
        return ret;
    }
    public boolean minPair(Word a, Word b){
        //iteratively compare meanings
        int shared=0;
        int aKnown=0;
        int bKnown=0;
        for (int i=0;i<(a.meaning).size();i++){
            if (solution.contains(a.meaning.get(i))!=-1){
                aKnown++;
            }
            else if(b.meaning.contains(a.meaning.get(i))){
                shared++;
            }
        }
        for (int i=0;i<b.meaning.size();i++){
            if (solution.contains(b.meaning.get(i))!=-1){
                bKnown++;
            }
        }
        

        System.out.println("shared = "+shared+" aK = "+aKnown+" bK = "+bKnown);

        boolean oneUniqueA = (a.meaning.size()-aKnown-shared)<=1;
        boolean oneUniqueB = (b.meaning.size()-bKnown-shared)<=1;

        return oneUniqueA && oneUniqueB;
    }
    //minPair iff only one element in meaning is unique from the other, excluding known
    // {"Fish", ".pl"}, {"Dog", ".pl"}
    // a.meaning.size() = 2, shared = 1, aK = 0
    // b.meanin.size() = 2, shared = 1, bK = 0

}

