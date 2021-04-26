import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class GUIv2 {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    Scanner scanner = null;

    public GUIv2()  {
        Dice die = new Dice();
        try {
            scanner = new Scanner(new BufferedReader(new FileReader("openingScreen.txt")));
            while (scanner.hasNext()) {
                String text = scanner.nextLine();
                System.out.println(text);
                if (die.rollFaces(3) == 2)
                    TimeUnit.MILLISECONDS.sleep(250);
            }
            System.out.println(ANSI_RED + "\n\n\n\n\n\n\n\n\t\t\t\t\t\t\t\t\t\t\t WARRING NATIONS" + ANSI_RESET);
            TimeUnit.MILLISECONDS.sleep(250);
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t IT IS NOW TIME TO PICK YOUR NATION!");
            TimeUnit.MILLISECONDS.sleep(250);
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t PICK ONE OF THE NATIONS BELOW TO START THE GAME");
            System.out.println(ANSI_GREEN + "\n\n\n\t\t\t\t\t\t\t\t\t\t\t Max's Nation" + ANSI_RESET);
            System.out.println(ANSI_BLUE + "\t\t\t\t\t\t\t\t\t\t\t Justin's Nation" + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "\t\t\t\t\t\t\t\t\t\t\t Elizabeth's Nation" + ANSI_RESET);
            System.out.println(ANSI_CYAN + "\t\t\t\t\t\t\t\t\t\t\t Tanishq's Nation" + ANSI_RESET);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    //can be found in encounter world 
    public String getNationName(String name) {
        return name;
    }

    public String getTribeName(String tribeName) {
        return tribeName;
    }

    public String getWarriorType(String warriorType) {
        return warriorType;
    }

    public String getStrategtyEnountered(String encounter) {
        return encounter;
    }

    public int getLifePoints(int lifePoints) {
        return lifePoints;
    }

    public int getManaUsed(int manaUsed) {
        return manaUsed;
    }


    //from the war function of World
    public String getWinner(String winner) {
        return winner;
    }

//    DEATH ARTIFACT           encounters          WARRIOR(maxwarrior1)
//       HEALTH: 70                                     HEALTH: 15
//       MANA: 100                                      MANA:10

//    DEATH ARTIFACT           encounters          WARRIOR(maxwarrior1)
//       HEALTH: 70                                     HEALTH: 15
//       MANA: 100                                      MANA:10


//    DEATH ARTIFACT           encounters          WARRIOR(maxwarrior1)
//       HEALTH: 70                                     HEALTH: 15
//       MANA: 100                                      MANA:10

//    DEATH ARTIFACT           encounters          WARRIOR(maxwarrior1)
//       HEALTH: 70                                     HEALTH: 15
//       MANA: 100                                      MANA:10


//    DEATH ARTIFACT           encounters          WARRIOR(maxwarrior1)
//       HEALTH: 70                                     HEALTH: 15
//       MANA: 100                                      MANA:10


//    DEATH ARTIFACT           encounters          WARRIOR
//                                             MaxNation / Tribe02
//                                                  HEALTH: 15
//                                                  MANA:10


//
}
