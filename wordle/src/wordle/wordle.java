package wordle;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//extra comments in evil version

public class wordle {
    String word;
    WordRecommender w;
    ArrayList<Character> list = new ArrayList<Character>();
    Set badGuess = new HashSet();
    //ArrayList<Character> badGuess = new ArrayList<Character>();
    Scanner s = new Scanner(System.in);
    Set goodGuess = new HashSet();
    int count = 0;
    wordle(){
        this.w = new WordRecommender();
        this.word = w.randomWord();
        
    }
    
    void boardSetUp(){
        int length = word.length();
        //System.out.print("Guess a letter");
        for( int i =0; i<length; i++) {
            this.list.add('_');
            //System.out.print("_ ");
        }
        
        
        
        
    }
    
    void boardDraw() {// draws the board
        System.out.println("Guess a word");
        for( int i =0; i<list.size(); i++) {
            
            System.out.print(list.get(i) + " ");
            }
        
        System.out.println("");
        
        
        
        if( 0<badGuess.size()) {
            System.out.print("good letters" + goodGuess);
            System.out.print("bad letters" + badGuess);
            }
        
        System.out.println("");
        
    }
    
    boolean checkIfDone() {// checks if game is over
        
        for(char x: list) {
            if (x == '_' && count <6){
                return false;
            }
        }
        boolean g= true;
        for(char x: list) {
            if (x == '_' ){
                g = false;
            }
        }
        if(g) {
            System.out.println("game over, good job The word was " + word);
            return true;  
        }
        
        if (count >= 6) {
            System.out.println("game over, Try again, The word was " + word);
            return true;
            
        }
        
        //System.out.println("game over, good job The word was " + word);
        return false;
    }
    
    void gameTurn() {
        boardDraw();
        String guess = s.next();
        int length = word.length();
        boolean badGuessBool = true;   
        boolean badGuessBool2 = true;  
        if (badGuess.contains(guess) || !w.five.contains( guess)){
            System.out.println("not a word or youve already guessed that");
            gameTurn();
            return;
            }
            
      for( int i =0; i<length; i++) {
          for( int j =0; j<guess.length(); j++) {
          if(word.charAt(i) == guess.charAt(i)) {
            list.set(i, guess.charAt(i));
            badGuessBool = false;
             badGuessBool2 = true; 
          }else {
              if (word.contains( Character.toString(guess.charAt(i))) ){
                  goodGuess.add(guess.charAt(i));
                  badGuessBool2 = true; 
              }
              else {
                  badGuess.add(guess.charAt(i));
              }
          }
          
          }
            }
      if(badGuessBool) {
         // badGuess.add(guess);
      }
        
        System.out.println("");
        
        count++;
        
        if(checkIfDone()) {
            return;
        }else {
            gameTurn();
        }
    }
    

}
