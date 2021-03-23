
public class TanishqWizzardB extends People
{
    TanishqWizzardB(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tTanishq Wizzard";
    }

    public int encounterStrategy(People otherPerson)
    {
        if (!this.getNation().equals(otherPerson.getNation()))
        {
            return this.getLifePoints();
        }
        else
        {
            return -100;
        }
    }
}
