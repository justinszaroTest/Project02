import java.util.ArrayList;

public class Nation
{
    private int lifePoints;
    private final String name;
    private final ArrayList<Tribe> tribes;
    private final ArrayList<People> population;
    private final ArrayList<People> livingPopulation;

    public Nation(String name, int lifePoints)
    {
        this.name = name;
        this.lifePoints = lifePoints;
        this.tribes = new ArrayList<>();

        for (int i = 0; i < 6; i++)
            this.tribes.add(new Tribe(this.name, "Tribe" + i, this.lifePoints / 6));

        livingPopulation = new ArrayList<>();
        recalculateLifePointsAndLivingPopulation();

        population = new ArrayList<>(livingPopulation);
        livingPopulation.addAll(population); // Is this a bug?
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<People> getNationPopulation()
    {
        recalculateLifePointsAndLivingPopulation();
        return livingPopulation;
    }

    private void recalculateLifePointsAndLivingPopulation()
    {
        lifePoints = 0;
        livingPopulation.clear();

        for (Tribe value : this.tribes)
        {
            if (value.isTribeAlive())
            {
                livingPopulation.addAll(value.getLivingTribeMembers());
                lifePoints += value.getTribeLifePoints();
            }
        }
    }

    public void printTribesStatus()
    {
        for (Tribe tribe : tribes)
        {
            if (tribe.isTribeAlive())
            {
                System.out.println(
                        tribe.getTribeName() + " is alive and has " +
                        tribe.getTribeSize() + " members.");
            }
            else
            {
                System.out.println(tribe.getTribeName() + " is dead.");
            }
        }
    }

    public String toString()
    {
        StringBuilder result = new StringBuilder(name);
        for (Tribe tribe : tribes)
            result.append('\n').append(tribe.toString());
        return result.append('\n').toString();
    }
}
