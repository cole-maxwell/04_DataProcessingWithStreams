package cs681;
import java.util.ArrayList;
import java.util.stream.Stream;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


class StartupSportsStats {
    public static void main(String[] args) {

        ArrayList<Integer> nbaPPG = new ArrayList<Integer>();
        try {
            File PPG = new File("NBAPointsPerGame.txt");
            Scanner scanner = new Scanner(PPG);
            while (scanner.hasNextLine()) {
              String strPoints = scanner.nextLine();
              Integer intPoints = Integer.parseInt(strPoints);
              nbaPPG.add(intPoints);
            }
            scanner.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }

        Long countGames = nbaPPG.stream()
            .filter( points -> points<100 )
            .count();

        System.out.println("--Number of NBA games out of " + nbaPPG.size() +
                            " games\nwith total points per game above 100--");
        System.out.println(countGames);
                                
                                                
    
                                    
    }
}