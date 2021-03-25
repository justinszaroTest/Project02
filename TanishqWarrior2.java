
public class TanishqWarrior2 extends People
{
    TanishqWarrior2(String nation, String tribe, int lifePoints)
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
            return this.getLifePoints() / 3;
        }
    }
}
