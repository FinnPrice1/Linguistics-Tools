package com.mycompany.app;

public class Root extends Morpheme{
    LexicalCat category;

    public Root(LexicalCat lc, String txt,String definition){
        // category=lc;
        super(txt,definition);
        category=lc;

    }
    
}