package com.mycompany.app;

import java.util.LinkedList;


public class Solution{
    private class Node{
        // opts will have all the same meaning, just different text forms
        // e.g {cats, dogs, judges} all textwise the same, phonetically dif
        LinkedList<String> opts;
        String definition;
        public String getDefinition(){
            return definition;
        }
        public Node(String def,String optFirst){
            opts = new LinkedList<>();
            opts.add(optFirst);
            definition=def;
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

    public int contains(String def){
        for (int i=0;i<nodes.size();i++){
            if (nodes.get(i).definition.equals(def)){
                return i;
            }
        }
        return -1;
    }

    public void add(Morpheme m){
        int index = this.contains(m.meaning);
        //case that nodes already has it
        if (index!=-1){
            //case that its text is different
            if (!nodes.get(index).opts.getFirst().equals(m.text))
                nodes.get(index).add(m.text);
        }
        else{
            nodes.addLast(new Node(m.meaning,m.text));
        }
    }

}

