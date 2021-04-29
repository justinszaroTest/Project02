/**
 * The Justin Healer 1 is a saint and heals everyone on the battlefield, no matter the nation or the character type.
 *
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 3.0
 * @since 2021-04-11
 */
public class JustinHealer1 extends People
{
    /**
     * Instantiates a JustinHealer1 Object and establishes its properties.
     * @param nation the nations name
     * @param tribe the tribes name
     * @param lifePoints the number of lifepoints
     */
    JustinHealer1(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.cleric, lifePoints, "Justin's Healer");
        myDescription = "\tJustin Healer";
    }


    /**
     * Returns the number of lifepoints to be used in the encounter.
     * @param otherPerson Other Person who is involved in the encounter
     * @return -5 lifepoints which is used to heal others.
     */
    public int encounterStrategy(People otherPerson) //Is a saint, heals  Everyone
    {
        return -5;
    }

}

