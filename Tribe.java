import java.util.ArrayList;

public class Tribe
{
    private String nationName;
    private String tribeName;
    private int tribeLifePoints;
    private ArrayList<People> members = new ArrayList<>();
    private ArrayList<People> livingMembers = new ArrayList<>();

    public Tribe(String nation, String tribe, int lifePoints)
    {
        nationName = nation;
        tribeName = tribe;
        tribeLifePoints = lifePoints;

        if (nationName.equals("Justin's Nation")) {
            members.add(new JustinWarrior1(nationName, tribeName, tribeLifePoints / 6));
            members.add(new JustinWizard1(nationName, tribeName, tribeLifePoints / 6));
            members.add(new JustinHealer1(nationName, tribeName, tribeLifePoints /6));
            members.add(new JustinWarrior2(nationName, tribeName, tribeLifePoints / 6));
            members.add(new JustinWizard2(nationName, tribeName, tribeLifePoints / 6));
            members.add(new JustinHealer2(nationName, tribeName, tribeLifePoints /6));
        }
        else if (nationName.equals("Maxwell's Nation")) {
            members.add(new MaxwellHealer01(nationName, tribeName, tribeLifePoints /6));
            members.add(new MaxwellHealer02(nationName, tribeName, tribeLifePoints /6));
            members.add(new MaxwellWarrior01(nationName, tribeName, tribeLifePoints /6));
            members.add(new MaxwellWarrior02(nationName, tribeName, tribeLifePoints /6));
            members.add(new MaxwellWizard01(nationName, tribeName, tribeLifePoints /6));
            members.add(new MaxwellWizard02(nationName, tribeName, tribeLifePoints /6));
        }
        else if (nationName.equals("Tanishq's Nation")) {
            members.add(new TanishqHealer1(nationName, tribeName, tribeLifePoints /6));
            members.add(new TanishqHealer2(nationName, tribeName, tribeLifePoints /6));
            members.add(new TanishqWarrior1(nationName, tribeName, tribeLifePoints /6));
            members.add(new TanishqWarrior2(nationName, tribeName, tribeLifePoints /6));
            members.add(new TanishqWizard1(nationName, tribeName, tribeLifePoints /6));
            members.add(new TanishqWizard2(nationName, tribeName, tribeLifePoints /6));
        }
        else if (nationName.equals("Elizabeth's Nation")) {
            members.add(new ElizabethWarrior(nationName, tribeName, tribeLifePoints / 6));
            members.add(new ElizabethWizard(nationName, tribeName, tribeLifePoints / 6));
            members.add(new ElizabethHealer(nationName, tribeName, tribeLifePoints / 6));
            members.add(new ElizabethWizardSecond(nationName, tribeName, tribeLifePoints / 6));
            members.add(new ElizabethHealerSecond(nationName, tribeName, tribeLifePoints / 6));
            members.add(new ElizabethWarriorSecond(nationName, tribeName, tribeLifePoints / 6));
        }
        



        for(int i = 0; i < members.size(); i++)
            livingMembers.addAll(members);
    }

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
    /*
    public void printMembers()
    {
        for(int i = 0; i < 2; i++)
        {
            System.out.println(people.get(i));
        }
    }
*/


    public int getTribeSize()
    {
        return livingMembers.size();
    }

    public Boolean isTribeAlive()
    {
        return (tribeLifePoints > 0);
    }


    public int getTribeLifePoints()
    {
        return tribeLifePoints;
    }

    public String getTribeName()
    {
        return tribeName;
    }

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
