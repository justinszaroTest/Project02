

/**
 * Tanishq's class for Wizard type.
 */
public class TanishqWizard1 extends People
{
    /**
     * Basic Constructor.
     * @param nation name of nation.
     * @param tribe name of tribe.
     * @param lifePoints number of life points.
     */
    TanishqWizard1(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tTanishq Wizard";
    }

    /**
     * The strategy heals 2 for friend and damages life points difference for enemy.
     * @param otherPerson Other Person who is involved in the encounter
     * @return negative number if friend, positive if enemy.
     */
    public int encounterStrategy(People otherPerson)
    {
        if (this.getNation().equals(otherPerson.getNation()))
        {
            return -2;
        }
        else
        {
            return Math.abs(this.getLifePoints() - otherPerson.getLifePoints());
        }
    }
}
