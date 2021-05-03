import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Class for printing the GUI in the terminal.
 */
public class GUI {
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
    String nationName;

    /**
     * Constructs a GUI class.
     * Prints out the start screen.
     */
    public GUI()  {
        Dice die = new Dice();
        String Max = "Max's Nation!";
        String Justin = "Justin's Nation!";
        String Elizabeth = "Elizabeth's Nation!";
        String Tanishq = "Tanishq's Nation!";
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


            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t PICK ONE OF THE NATIONS BELOW TO START THE GAME");




            System.out.println(ANSI_GREEN + "\n\n\n\t\t\t\t\t\t\t\t\t\t\t" + Max + ANSI_RESET);
            System.out.println(ANSI_BLUE + "\t\t\t\t\t\t\t\t\t\t\t" + Justin + ANSI_RESET);
            System.out.println(ANSI_PURPLE + "\t\t\t\t\t\t\t\t\t\t\t" + Elizabeth + ANSI_RESET);
            System.out.println(ANSI_CYAN + "\t\t\t\t\t\t\t\t\t\t\t" + Tanishq + ANSI_RESET);

            nationName = myObj.nextLine();  // Read user input
            System.out.println("You selected: " + nationName);  // Output user input

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Prints the number of the current round.
     * @param roundNumber the number of the current round.
     */
    public void printRoundNumber(int roundNumber) {
        System.out.println("\n\n\n" + ANSI_GREEN + "\t\t\t\t\t\t\t\t\t\t\t ROUND" + roundNumber + ANSI_RESET);
    }

    /**
     * Prints result of an encounter.
     * @param person the Person.
     * @param damage the damage or health afflicted on the person.
     * @return a String if no damage.
     */
    public String printStatus(People person, int damage) {
        if (person.getNation().equals("Artifact's Nation"))
            return "\t\t\t\t\t"  + person.getMyDescription();
        else if (damage > 0)
            return "\t\t\t\t\t" + person.getName() + " takes " + damage + " damage!";
        else if (damage < 0)
            return "\t\t\t\t\t" + person.getName() + " gains " + damage * -1 + " health!";
        return "\t\t\t\t" + person.getName() + " takes no damage!";
    }


    /**
     * Prints an encounter.
     * @param person1 the first person.
     * @param person2 the second person
     * @param person1Damage damage dealt by first person.
     * @param person2Damage damage dealt by second person.
     */

    public void printEncounter(People person1, People person2, int person1Damage, int person2Damage) {
        try {
            System.out.println(ANSI_RED + "\t\t\t\t\t" + person1.getName() + ANSI_BLUE + "\t\t\t\t\t\t" + person2.getName() + ANSI_RESET);
            System.out.println(ANSI_RED + "\t\t\t\t\t" + person1.getNation() + ANSI_BLUE + "\t\t\t\t\t\t" + person2.getNation() + ANSI_RESET);
            System.out.println(ANSI_RED + "\t\t\t\t\t" + person1.getTribe() + ANSI_BLUE + "\t\t\t\t\t\t\t\t\t" + person2.getTribe() + ANSI_RESET);
            System.out.println(ANSI_RED + "\t\t\t\t\t" + "Lifepoints: " + person1.getLifePoints() + ANSI_BLUE + "\t\t\t\t\t\t\t" + "Lifepoints: " + person2.getLifePoints() + ANSI_RESET);
            System.out.println(ANSI_RED + printStatus(person1, person1Damage) + ANSI_BLUE + printStatus(person2, person2Damage) + ANSI_RESET);
            TimeUnit.MILLISECONDS.sleep(1000);
        }
        catch (Exception e) {
            System.out.print("Something went wrong!");
        }
    }

    public void gameOver(Set<String> survivingNations){
        if (survivingNations.equals(Collections.singleton(nationName))) {
            System.out.print(ANSI_YELLOW + "\t\t\t\t\tCONGRATS!!! YOU HAVE WON WARRING NATIONS" + ANSI_RESET);
        }
        else {
            System.out.println("\t\t\t\t\tThats ashame, your nation lost..... Better luck next game!!!");
        }

    }

    public void noWinner()  {
        System.out.println(ANSI_YELLOW + "All Nations Destroyed." + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "Sorry, you lost!" + ANSI_RESET);
    }

    public void winner(Set<String> survivingNations, ArrayList<Integer> worldSurvivingPeople, ArrayList<People> worldCreatedPeople) {
        System.out.println(ANSI_YELLOW + survivingNations);
        System.out.println("The survivors are:");
        for (Integer worldSurvivingPerson : worldSurvivingPeople) {
            System.out.println(ANSI_YELLOW + worldCreatedPeople.get(worldSurvivingPerson) + ANSI_RESET);
        }
    }


}
