/**
 * The Justin Warrior 1 gives a lifepoint to members of its own nation. If the opponent is of another nation, the
 * warrior will use as many lifepoints as it has or the same number of opponents lifepoints if its health is less.
 *
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 3.0
 * @since 2021-04-11
 */
public class JustinWarrior1 extends People
{
    /**
     * Instantiates a JustinWarrior1 Object and establishes its properties.
     * @param nation the nations name
     * @param tribe the tribes name
     * @param lifePoints the number of lifepoints
     */
    JustinWarrior1(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tJustin Warrior";
    }

    /**
     * Returns the number of lifepoints to be used in the encounter.
     * @param otherPerson Other Person who is involved in the encounter
     * @return lifepoints number of lifepoints to be used in the encounter.
     */
    public int encounterStrategy(People otherPerson)
    {
        int lifePoints = 0;
        if(this.getNation().equals(otherPerson.getNation()))
        {
            if(otherPerson.getLifePoints() < this.getLifePoints())
            {
                if(otherPerson.getTribe().equals(this.getTribe()))
                {
                    lifePoints = -1;
                }
            }
        }
        else
        {
            int points;
            points = this.getLifePoints() - otherPerson.getLifePoints();
            if (points > 0)
            {
                lifePoints = otherPerson.getLifePoints();
            }
            else
            {
                lifePoints = this.getLifePoints();
            }
        }
        return lifePoints;
    }

}

