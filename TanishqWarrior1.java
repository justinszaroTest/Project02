
public class TanishqWarrior1 extends People
{
    TanishqWarrior1(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tTanishq Warrior";
    }

    public int encounterStrategy(People otherPerson)
    {
        if (!this.getNation().equals(otherPerson.getNation()))
        {
            return -1;
        }
        else
        {
            return this.getLifePoints() / 4;
        }
    }
}
