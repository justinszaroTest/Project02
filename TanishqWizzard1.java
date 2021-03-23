
public class TanishqWizzard1 extends People
{
    TanishqWizzard1(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints);
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
