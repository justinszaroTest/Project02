import java.util.ArrayList;

public class TheFlashArtifact extends People  {
    private String nationName;
    private String tribeName;
    private int tribeLifePoints;
    private ArrayList<People> members = new ArrayList<>();
    private ArrayList<People> livingMembers = new ArrayList<>();

    public TheFlashArtifact(String nation, String tribe, int lifePoints) {

        super(nation, tribe, PeopleType.TheFlash, lifePoints);
        myDescription = "\tThe Flash time traveled and brought more soldiers from the past";
    }



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
