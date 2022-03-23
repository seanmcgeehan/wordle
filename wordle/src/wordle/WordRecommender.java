package wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordRecommender {

    String filename;
    ArrayList<String> wordSuggestions = new ArrayList<String>();
    ArrayList<String> dictionary = new ArrayList<String>();
   // filename = "engDictionary.txt";
    File engDictionary = new File("src/engDictionary.txt");
    HashSet<String> five = new HashSet<String>();
    
    //String filename
    
    public WordRecommender() {
        Scanner fileScanner;
 //     textReader myTextReader = new textReader();
    try {
        fileScanner = new Scanner(engDictionary);
        fileScanner.nextLine();
        while (fileScanner.hasNextLine()) { 
            dictionary.add(fileScanner.nextLine()); 
        }
    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    
    for(String word : dictionary) {
        if(word.length()==5) {
            five.add(word);
        }
        
    }
    
    
    }
    
    String randomWord() {
        //get random number number within size of dictionary
        //return that element of dictionary
        Random r = new Random();
        
        
        int randNum =  r.nextInt(five.size());
        String[] arrayNumbers = five.toArray(new String[five.size()]);
        return arrayNumbers[randNum] ;
        
    }
    
    
}