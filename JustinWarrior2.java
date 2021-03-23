public class JustinWarrior2 extends People
{
    JustinWarrior2(String nation, String tribe, int lifePoints)
    {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription = "\tJustin Warrior";
    }


    public int encounterStrategy(People otherPerson)
    {
        int lifePoints = 0;
        if(this.getNation() == otherPerson.getNation())
        {
            if(otherPerson.getLifePoints() < this.getLifePoints())
            {
                if(otherPerson.getTribe() == this.getTribe())
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
                lifePoints = otherPerson.getLifePoints() / 2;
            }
            else
            {
                lifePoints = this.getLifePoints() / 2;
            }
        }
        return lifePoints;
    }

}
