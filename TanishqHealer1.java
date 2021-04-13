
public class TanishqHealer1 extends People
{
    TanishqHealer1(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.cleric, lifePoints);
        myDescription = "\tTanishq Healer 01";
    }

    public int encounterStrategy(People otherPerson)
    {
        if (!this.getNation().equals(otherPerson.getNation()))
        {
            return -5;
        }
        else
        {
            return -2;
        }
    }
}
