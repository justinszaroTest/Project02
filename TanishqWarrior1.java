
/**
 * Tanishq's class for Warrior type.
 */
public class TanishqWarrior1 extends People
{
    /**
     * Basic Constructor.
     * @param nation name of nation.
     * @param tribe name of tribe.
     * @param lifePoints number of life points.
     */
    TanishqWarrior1(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tTanishq Warrior";
    }

    /**
     * The strategy heals 1 for friend and damages life points / 4 for enemy.
     * @param otherPerson Other Person who is involved in the encounter
     * @return negative number if friend, positive if enemy.
     */
    public int encounterStrategy(People otherPerson)
    {
        if (this.getNation().equals(otherPerson.getNation()))
        {
            return -1;
        }
        else
        {
            return this.getLifePoints() / 4;
        }
    }
}
