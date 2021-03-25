
public class TanishqWizard2 extends People
{
    TanishqWizard2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tTanishq Wizard";
    }

    public int encounterStrategy(People otherPerson)
    {
        if (!this.getNation().equals(otherPerson.getNation()))
        {
            return -2;
        }
        else
        {
            return this.getLifePoints()/4;
        }
    }
}
