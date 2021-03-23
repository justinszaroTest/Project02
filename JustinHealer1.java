public class JustinHealer1 extends People
{
    JustinHealer1(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.cleric, lifePoints);
        myDescription = "\tJustin Healer";
    }


    public int encounterStrategy(People otherPerson) //Is a saint, heals  Everyone
    {
        return -5;
    }

}

