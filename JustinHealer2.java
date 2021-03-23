public class JustinHealer2 extends People
{
    JustinHealer2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.cleric, lifePoints);
        myDescription = "\tJustin Healer";
    }


    public int encounterStrategy(People otherPerson) //only heals their team, tries to run if its anyone else
    {
        int lifePoints = 0;
        if(this.getNation() != otherPerson.getNation())
        {
           lifePoints = -this.getLifePoints() / 10;
        }
        else
        {
            lifePoints = -5;
        }
        return lifePoints;
    }

}
