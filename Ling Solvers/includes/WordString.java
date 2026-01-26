public class WordString{
    private String chars;
    private String[] gloss;

    public WordString(String c, String[] g){
        chars=c;
        gloss=g;
    }
    public String getChars(){
        return chars;
    }
    public String[] getGloss(){
        return gloss;
    }
    public String toString(){
        String ret ="Form: "+chars+" Meaning: ";
        
        for (int i=0;i<gloss.length;i++){
            if (gloss[i]!=""){
                ret+=gloss[i]+", ";
            }
        }
        return ret;
    }

    public WordString subtract(WordString other){
        chars=chars.replace(other.getChars(),"");
        //System.out.println(chars);
        String[] oG = other.getGloss();
        for (int i=0;i<gloss.length;i++){
            for (int j=0;j<oG.length;j++)
                if (gloss[i]==other.getGloss()[j]){
                    gloss[i]="";
                }
        }
        return this;
    }
    public WordString compareInfix(WordString other){
        String form = "?";
        int x = 1;
        String oChars = other.getChars();
        for (int i=1;i<chars.length();i++){
            for (int j=0;j<oChars.length();j++){
                if (chars.charAt(i)==oChars.charAt(j)){
                    x+=i;
                    while (oChars.contains(chars.substring(i,x))){
                        form=chars.substring(i,x);
                        x++;
                    }
                    return new WordString(form,glossComp(other));
                }
            }
        }
        return new WordString(".",new String[1]);
    }
    //returns shared form, which must then be subtracted from original to find true meaning
    public WordString compareSuffix(WordString other){
        String form=",";
        int x=chars.length()-1;
        while (other.getChars().contains(chars.substring(x))){
            form = chars.substring(x);
            x--;
        }
        return new WordString(form, glossComp(other));
    }

    public WordString comparePrefix(WordString other){
        String form=".";
        int x=1;
        while (other.getChars().startsWith(chars.substring(0,x))&&x<chars.length()){
            form = chars.substring(0,x);
            x++;
        }
        return new WordString(form, glossComp(other));
    }
    public String[] glossComp(WordString other){
        String[] meaning= new String[gloss.length];
        String[] oG=other.getGloss();
        int glossInd=0;
        for (int i=0;i<gloss.length;i++){
            for (int j=0;j<oG.length;j++){
                if (gloss[i].equals(oG[j])){
                    meaning[glossInd]=gloss[i];
                    glossInd++;
                }
            }
        }
        return meaning;
    }

    public static void main(String[] args) {
        String[] poStrings = {"toru","see",".pst","kumiko"};
        String[] yamStrings = {"kumiko","see",".pst","toru"};
        WordString potat = new WordString("Toru-ga Kumiko-o mita",poStrings);
        WordString yam = new WordString("Kumiko-ga Toru-o mita", yamStrings);
        WordString alt = potat.comparePrefix(yam);
        WordString suf = potat.compareSuffix(yam);
        WordString dif = potat.compareInfix(yam);
        //WordString alt = potat.comparePrefix(yam);
        System.err.println(alt.toString());
        System.err.println(suf.toString());
        System.err.println(dif.toString());

        System.out.println(yam.subtract(dif).subtract(alt).subtract(suf));
    }
}
