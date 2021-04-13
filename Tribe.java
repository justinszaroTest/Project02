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
    private final String tribeName;
    private int tribeLifePoints;
    private final ArrayList<People> members = new ArrayList<>();
    private final ArrayList<People> livingMembers = new ArrayList<>();

    /**
     * Tribe function is called in Nation passing. It instantiates the members for the corresponding tribes.
     * @param nation - String of the Nation name
     * @param tribe - String of Tribe's index (0-2)
     * @param lifePoints - Int of the lifepoints - should be 500 be default
     *
     */
    public Tribe(String nation, String tribe, int lifePoints)
    {
        tribeName = tribe;
        tribeLifePoints = lifePoints;

        if (nation.equals("Justin's Nation")) {
            members.add(new JustinWarrior1(nation, tribeName, tribeLifePoints / 6));
            members.add(new JustinWizard1(nation, tribeName, tribeLifePoints / 6));
            members.add(new JustinHealer1(nation, tribeName, tribeLifePoints /6));
        }
        else if (nation.equals("Maxwell's Nation")) {
            members.add(new MaxwellHealer01(nation, tribeName, tribeLifePoints /6));
            members.add(new MaxwellWarrior01(nation, tribeName, tribeLifePoints /6));
            members.add(new MaxwellWizard01(nation, tribeName, tribeLifePoints /6));
        }
        else if (nation.equals("Tanishq's Nation")) {
            members.add(new TanishqHealer1(nation, tribeName, tribeLifePoints /6));
            members.add(new TanishqWarrior1(nation, tribeName, tribeLifePoints /6));
            members.add(new TanishqWizard1(nation, tribeName, tribeLifePoints /6));
        }
        else if (nation.equals("Elizabeth's Nation")) {
            members.add(new ElizabethWarrior(nation, tribeName, tribeLifePoints / 6));
            members.add(new ElizabethWizard(nation, tribeName, tribeLifePoints / 6));
            members.add(new ElizabethHealer(nation, tribeName, tribeLifePoints / 6));
        }

        else if (nation.equals("Artifact's Nation")) {
            //we add our special characters
            members.add(new ElizabethArtifact(nation,tribeName, lifePoints / 4));
            members.add(new DeathArtifact(nation, tribeName, lifePoints / 4));
            members.add(new TheFlashArtifact(nation,tribeName, lifePoints/4));


        }

        for(int i = 0; i < members.size(); i++)
            livingMembers.addAll(members);
    }

    /**
     * This checks the Tribe members that are alive.
     * The list is cleared and restarted as well as the Tribe's life points
     * By loop through, the size of the member list times, check to see if
     * the member list as an alive member at the position of person.
     * If that person is alive, add them to the livingMembers list and the tribe's
     * lifepoints have that member's lifeponts added to it.
     * @return the final list of living members
     */
    public ArrayList<People> getLivingTribeMembers()
    {
        livingMembers.clear();
        tribeLifePoints = 0;
        for (People member : members) {
            if (member.isPersonAlive()) {
                livingMembers.add(member);
                tribeLifePoints += member.getLifePoints();
            } else {
                if (!(member.getDead())) {
                    member.setDead();
                    System.out.println("\t\t" + member + " is dead!");
                }
            }
        }
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
        StringBuilder result;

        result = new StringBuilder(tribeName);
        for (People member : members) {
            result.append('\n').append(member.toString());
        }
        result.append('\n');
        return result.toString();
    }

}
