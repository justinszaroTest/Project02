import java.util.ArrayList;
/**
 * The Tribes are made here using the Nation class. Then the living tribe members can be found using getLivingTribeMembers, as well as
 * tribe size, tribe life points, tribe name and if they are alive.
 *
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 3.0
 * @since 2021-04-11
 */
public class Tribe
{
    private String nationName;
    private String tribeName;
    private int tribeLifePoints;
    private ArrayList<People> members = new ArrayList<>();
    private ArrayList<People> livingMembers = new ArrayList<>();

    /**
     * Tribe function is called in Nation passing. It instantiates the members for the corresponding tribes.
     * @param nation - String of the Nation name
     * @param tribe - String of Tribe's index (0-2)
     * @param lifePoints - Int of the lifepoints - should be 500 be default
     *
     */
    public Tribe(String nation, String tribe, int lifePoints)
    {
        nationName = nation;
        tribeName = tribe;
        tribeLifePoints = lifePoints;

        if (nationName.equals("Justin's Nation")) {
            members.add(new JustinWarrior1(nationName, tribeName, tribeLifePoints / 6));
            members.add(new JustinWizard1(nationName, tribeName, tribeLifePoints / 6));
            members.add(new JustinHealer1(nationName, tribeName, tribeLifePoints /6));
        }
        else if (nationName.equals("Maxwell's Nation")) {
            members.add(new MaxwellHealer01(nationName, tribeName, tribeLifePoints /6));
            members.add(new MaxwellWarrior01(nationName, tribeName, tribeLifePoints /6));
            members.add(new MaxwellWizard01(nationName, tribeName, tribeLifePoints /6));
        }
        else if (nationName.equals("Tanishq's Nation")) {
            members.add(new TanishqHealer1(nationName, tribeName, tribeLifePoints /6));
            members.add(new TanishqWarrior1(nationName, tribeName, tribeLifePoints /6));
            members.add(new TanishqWizard1(nationName, tribeName, tribeLifePoints /6));
        }
        else if (nationName.equals("Elizabeth's Nation")) {
            members.add(new ElizabethWarrior(nationName, tribeName, tribeLifePoints / 6));
            members.add(new ElizabethWizard(nationName, tribeName, tribeLifePoints / 6));
            members.add(new ElizabethHealer(nationName, tribeName, tribeLifePoints / 6));
        }

        else if (nationName.equals("Artifact's Nation")) {
            //we add our special characters
            members.add(new ElizabethArtifact(nationName,tribeName, lifePoints / 4));
            members.add(new DeathArtifact(nationName, tribeName, lifePoints / 4));
            members.add(new TheFlashArtifact(nationName,tribeName, lifePoints/4));
        }

        for(int i = 0; i < members.size(); i++)
            livingMembers.addAll(members);
    }

    /**
     * This checks the Tribe members that are alive.
     * The list is cleared and restarted as well as the Tribe's life points
     * By loop through, the size of the member list times, check to see if
     * the memeber list as an alive member at the position of person.
     * If that person is alive, add them to the livingMembers list and the tribe's
     * lifepoints have that member's lifeponts added to it.
     * @return the final list of living members
     */
    public ArrayList<People> getLivingTribeMembers()
    {
        livingMembers.clear();
        tribeLifePoints = 0;
        for(int person = 0; person < members.size(); person++)
        {
            if(members.get(person).isPersonAlive())
            {
                livingMembers.add(members.get(person));
                tribeLifePoints += members.get(person).getLifePoints();
                //System.out.println(members.get(person));
            }
            else
            {
                if(!(members.get(person).getDead()))
                {
                    members.get(person).setDead();
                    System.out.println("\t\t" + members.get(person) + " is dead!");
                }
            }
        }
        //System.out.println(livingMembers);
        return livingMembers;
    }

    /**
     *  To get the living members of the tribe
     * @return the number of people still alive in the tribe.
     */
    public int getTribeSize()
    {
        return livingMembers.size();
    }

    /**
     * Returns a boolean if the tribe have lifepoints left.
     * @return Boolean If tribe is alive return true, else return false.
     */
    public Boolean isTribeAlive()
    {
        return (tribeLifePoints > 0);
    }

    /**
     * returns the tribes life points as an integer
     * @return tribeLifePoints
     */
    public int getTribeLifePoints()
    {
        return tribeLifePoints;
    }

    /**
     * Returns the tribes name.
     * @return tribeName Name of the tribe
     */
    public String getTribeName()
    {
        return tribeName;
    }

    /**
     * Returns a string with the tribes name and its members.
     * @return result the properties of the tribe
     */
    public String toString()
    {
        String result = "\0";

        result = tribeName;
        for(int i = 0; i < members.size(); i++)
        {
            result = result + '\n' + members.get(i).toString();
        }
        result = result + '\n';
        return result;
    }

}
