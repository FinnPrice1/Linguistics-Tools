
public class Morpheme{
    private String chars;
    private String gloss;
    public Morpheme(String c, String g){
        chars=c;
        gloss=g;
    }
    public String toString(){
        return "Form: "+chars+" meaning: "+gloss;
    }
    public String getChars(){
        return chars;
    }
    public String getGloss(){
        return gloss;
    }
}