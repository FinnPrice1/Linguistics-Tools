package com.mycompany.app;

public class Affix extends Morpheme {
    int priority;
    LexicalCat attachTo;
    LexicalCat mapsTo;
    public Affix(String txt,String definition,LexicalCat attach,LexicalCat map){
        super(txt, definition);
        attachTo=attach;
        mapsTo=map;
    }    
}