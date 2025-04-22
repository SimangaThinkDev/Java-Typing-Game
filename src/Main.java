import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    // This is a typing game, Easy to follow so not instructions.
    // ENJOY!

    private static Scanner scanner = new Scanner( System.in );

    public static void main(String[] args) throws Exception {

        // Logic for the main Thread

        ArrayList<String> difficultyLevels = new ArrayList<>() ;

        // Add Difficulty levels to arraylist
        difficultyLevels.add( "easy" );
        difficultyLevels.add( "medium" );
        difficultyLevels.add( "hard" );

        System.out.println( "Please Choose Game difficulty" );

        int enumerate = 1;

        for ( String difficulty : difficultyLevels ) {

            System.out.println( enumerate + ". " + difficulty );
            enumerate ++;

        }
        String response = scanner.nextLine();
        ArrayList< String > words = new ArrayList<>();
        
        
        if ( difficultyLevels.contains(response.toLowerCase().strip()) ) {

            words = getFile( response + ".txt" );
            
        } else {
            System.out.println( "Bad Command" );
            main(args); // Recall Main
        }
        
        // for ( String word : words ) {
        //     System.out.println( word );
        // }

        /*
         * Random generator = new Random();
            int randomIndex = generator.nextInt(myArray.length);
            return myArray[randomIndex];
         */
        Random generator = new Random();
        int randomIndex = generator.nextInt( words.size() );
        MyRunnable timer = new MyRunnable( 3 );
        Thread r = new Thread( timer );
        r.setDaemon(true);
        r.start();
        boolean gameContinues = true;


        while ( gameContinues ) {
            String randomWord = words.get(randomIndex);

            System.out.println( "The word is: " + randomWord );
    
            // TODO: implement logic to handle typing a word with the timer active concurrently
            response = scanner.nextLine();
    
    
    
            if ( response.strip().toLowerCase().equals( randomWord.toLowerCase().strip() ) ) {
    
                System.out.println( "Correct!!" );
    
            } else {
    
                System.out.println( "That was incorrect!!" );
                gameContinues = false;
    
            }
        }
        System.out.println( "Game Over" );
        scanner.close();
        
    }

    public static ArrayList< String > getFile( String path ) throws FileNotFoundException {
        
        ArrayList<String> words = new ArrayList<>();
        
        File myObj = new File( path );
        try ( Scanner myReader = new Scanner( myObj ) ){
            
            while ( myReader.hasNextLine() ) {
                words.add( myReader.nextLine() );
            }
            
        }
        catch ( FileNotFoundException e ) {
            throw new FileNotFoundException(" File Not found ");
        }

        return words;
    }

}
