
public class TanishqWizard1 extends People
{
    TanishqWizard1(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints);
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
            return Math.abs(this.getLifePoints() - otherPerson.getLifePoints());
        }
    }
}
