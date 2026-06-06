package com.mycompany.app;

import java.util.LinkedList;


public class Solution{
    private class Node{
        // opts will have all the same meaning, just different text forms
        // e.g {cats, dogs, judges} all textwise the same, phonetically dif
        LinkedList<String> opts;
        String meaning;
        public String getMeaning(){
            return meaning;
        }
        public Node(String mean,String optFirst){
            opts = new LinkedList<>();
            opts.add(optFirst);
            meaning=mean;
        }
        public void add(String o){
            opts.add(o);
        }
        // TODO add some way to get all the string opts later
        public String[] getOpts(){
            String[] ret ={"XYZ"};
            return ret;
        }
    }

    LinkedList<Node> nodes;
    
    public Solution(){
        nodes = new LinkedList<>();
    }

    public int contains(String meaning){
        for (int i=0;i<nodes.size();i++){
            if (nodes.get(i).meaning.equals(meaning)){
                return i;
            }
        }
        return -1;
    }
    public void add(Morpheme m){
        add(m.meaning,m.text);
    }
    public void add(String meaning, String text){
        int index = this.contains(meaning);
        //case that nodes already has it
        if (index!=-1){
            //case that its text is different
            if (!nodes.get(index).opts.getFirst().equals(text))
                nodes.get(index).add(text);
        }
        else{
            nodes.addLast(new Node(meaning,text));
        }
    }

}

