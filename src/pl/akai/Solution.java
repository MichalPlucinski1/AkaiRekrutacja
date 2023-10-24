package pl.akai;

//Michał Pluciński 2023 
// 3 sem INF 

import java.util.ArrayList;

public class Solution {

    private class Word{
        private final String id; // must be unique, so named it id
        private int count;
        static ArrayList<Word> words;
        public String getId() {
            return id;
        }
        public int getCount() {
            return count;
        }
        public void inc() {
            this.count++;
        }
        public Word(String id) {
            this.id = id;
            this.count = 1;
        }
        @Override
        public String toString() {
            return "słowo: " + id + ", ilość = " + count;
        }
        public static void showWords(){
            if (words.size() == 0){
                System.out.println("\nthere are no words in tab\n");
                return;
            }
            for(var x : Word.words){
                System.out.println(x);
            }
        }
        public static Word findWord(String id){
            for(var w:words){
                if(w.getId().equals(id)) {
                    return w;
                }
            }
            return null;
        }
    }


    public void solve(String[] sentences){
        String arrayOfWords = String.join(" ",sentences); //making string from string arrays
        Word.words = new ArrayList<>();

        for(var s : arrayOfWords.split(" ")){ // looking into each word as separated element
            Word w = Word.findWord(s);
            if(w == null)
                Word.words.add(new Word(s));
            else{
                w.inc(); // incrementing quantity of found word
            }
        }


        Word.words.sort((w1, w2) ->  w2.getCount() - w1.getCount());   //I know, it could be Comparator.comparingInt(), just haven't used lambda yet

        // yes! that's the end ;)
        if(Word.words.size() >= 3){
            System.out.println("1. " + Word.words.get(0));
            System.out.println("2. " + Word.words.get(1));
            System.out.println("3. " + Word.words.get(2));

            //Word.showWords();     //showing all words
        }
        else{
            System.out.println("Less then 3 words were given");
        }

    }
}
