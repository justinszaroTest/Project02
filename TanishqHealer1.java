/**
 * Tanishq's class for Healer type.
 */
public class TanishqHealer1 extends People
{
    /**
     * Basic Constructor.
     * @param nation name of nation.
     * @param tribe name of tribe.
     * @param lifePoints number of life points.
     */
    TanishqHealer1(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.cleric, lifePoints, "Tanishq's Healer");
        myDescription = "\tTanishq Healer 01";
    }

    /**
     * The strategy heals 5 for friend and 2 for enemy.
     * @param otherPerson Other Person who is involved in the encounter
     * @return a negative number for healing.
     */
    public int encounterStrategy(People otherPerson)
    {
        if (this.getNation().equals(otherPerson.getNation()))
        {
            return -5;
        }
        else
        {
            return -2;
        }
    }
}
