import java.util.ArrayList;

/**
 * Artifact is The Flash who is able to travel through time.
 * When he is encountered he travels backword in time gets the past max's nation and takes them to the present
 * which then doubles the size of max's nation.
 */
public class TheFlashArtifact extends People  {
    private String nationName;
    private String tribeName;
    private int tribeLifePoints;
    private ArrayList<People> members = new ArrayList<>();
    private ArrayList<People> livingMembers = new ArrayList<>();

    /**
     * description of what the artifact is doing for myDescription
     * @param nation
     * @param tribe
     * @param lifePoints
     */
    public TheFlashArtifact(String nation, String tribe, int lifePoints) {

        super(nation, tribe, PeopleType.TheFlash, lifePoints);
        myDescription = "\tThe Flash time traveled and brought more soldiers from the past";
    }


    /**
     * when "The Flash" encounters someone of another nation, creates a new set of "Max's Nation" Healer, Wizard, Warrior
     * @param otherPerson Other Person who is involved in the encounter
     * @return
     */
    @Override
    public int encounterStrategy(People otherPerson)  {
        if ((!this.getNation().equals(otherPerson.getNation()))) {
        members.add(new MaxwellHealer01(nationName, tribeName, tribeLifePoints /6));
        members.add(new MaxwellWarrior01(nationName, tribeName, tribeLifePoints /6));
        members.add(new MaxwellWizard01(nationName, tribeName, tribeLifePoints /6));



        }
        return 0;
    }
}
