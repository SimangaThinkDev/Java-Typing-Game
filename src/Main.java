import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // This is a typing game, Easy to follow so not instructions.
    // ENJOY!

    private static Scanner scanner = new Scanner( System.in );

    public static void main(String[] args) throws Exception {

        // Logic for the main Thread

        String[] difficultyLevels = { "easy", "hard" } ;

        System.out.println( "Please Choose Game difficulty" );

        int enumerate = 1;

        for ( String difficulty : difficultyLevels ) {

            System.out.println( enumerate + ". " + difficulty );
            enumerate ++;

        }
        String response = scanner.nextLine();
        ArrayList<String> words = new ArrayList<>();

        
        if ( response.toLowerCase().equals( "easy" ) ) {
            
            File myObj = new File( "easy.txt" );
            try ( Scanner myReader = new Scanner( myObj ) ){
                
                while ( myReader.hasNextLine() ) {
                    words.add( myReader.nextLine() );
                }
                
            }
        }

        for ( String word : words ) {
            System.out.println( word );
        }

        scanner.close();

    }

}
