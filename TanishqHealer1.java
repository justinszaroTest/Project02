
public class TanishqHealer1 extends People
{
    TanishqHealer1(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.cleric, lifePoints);
        myDescription = "\tTanishq Healer A";
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
