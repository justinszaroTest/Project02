
import java.util.ArrayList;

/**
 * This class creates the Nations from World, and is able to pass that information to the Tribe class.
 * It checks the intended nations lifepoints to see if that are still alive in isNationAlive().
 *GetNationPopulation will go through and check to see if the tribe is alive, if they are the number of members is added to a living
 population list and the nations lifepoints are also documented.
 We can print the Tribes information, using getTribeName and getTribeSize in the printTribesStatus() function
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 3.0
 * @since 2021-04-11
 */
public class Nation
{
    private int nationLifePoints;
    private final String nationName;
    private final ArrayList<Tribe> tribes = new ArrayList<>();
    private final ArrayList<People> livingPopulation = new ArrayList<>();

    /**
     * Creates new 3 new tribes for every nation that is created. Also creates the artifact nation. The population
     * and living population is then found.
     * @param name the nations name
     * @param lifePoints the nations lifepoints
     */
    public Nation(String name, int lifePoints)
    {
        nationName = name;
        nationLifePoints = lifePoints;
        if (!nationName.equals("Artifact's Nation")) {
            for(int i = 0; i < 3; i++)
            {
                this.tribes.add(new Tribe(nationName, "Tribe" + i, nationLifePoints / 3));
            }
        }
        else {
            this.tribes.add(new Tribe(nationName, "Artifacts", lifePoints));
        }


        ArrayList<People> population = new ArrayList<>(getNationPopulation());
        livingPopulation.addAll(population);
    }
    /**
     * Finds the people in each tribe in each nation that are still alive
     * @return  livingPopulation An arrayList containing all living people.
     */
    public ArrayList<People> getNationPopulation()
    {
        nationLifePoints = 0;
        livingPopulation.clear();
        for (Tribe value : this.tribes) {
            if (value.isTribeAlive()) {
                //System.out.println(tribes.get(tribe));
                livingPopulation.addAll(value.getLivingTribeMembers());
                //System.out.println(tribes.get(tribe).getLivingTribeMembers());
                nationLifePoints += value.getTribeLifePoints();
            }
        }
        return livingPopulation;
    }


    /**
     * Returns the nations name.
     * @return nationName
     */
    public String getNationName()
    {
        return nationName;
    }

    /**
     * Checks if Tribe is alive
     * Checks if people in tribe are alive
     * Prints the results if people are alive and if they are dead
     */
    public void printTribesStatus()
    {
        for(int tribe = 0; tribe < 1; tribe++)
        {
            if(tribes.get(tribe).isTribeAlive())
            {
                System.out.print(tribes.get(tribe).getTribeName() + " is alive and has ");
                System.out.println(tribes.get(tribe).getTribeSize() + " members.");
            }
            else
            {
                System.out.println(tribes.get(tribe).getTribeName() + " is dead.");
            }
        }
    }

    /**
     * Makes a string of a nations current status, including its members and tribes.
     * @return result Summary of nation
     */
    public String toString()
    {
        StringBuilder result;
        result = new StringBuilder(nationName);
        for (Tribe tribe : tribes) {
            result.append('\n').append(tribe.toString());

        }
        result.append('\n');
        return result.toString();
    }
}
