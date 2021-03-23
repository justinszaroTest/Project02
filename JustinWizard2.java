public class JustinWizard2 extends People {
    JustinWizard2(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tJustin Wizard";
    }

    public int encounterStrategy(People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() != otherPerson.getNation()) {
            if (otherPerson.getLifePoints() < this.getLifePoints()) {
                if (otherPerson.getType() == PeopleType.cleric) // spare a cleric
                {
                    lifePoints = 0;
                } else // attack a wizard and cleric
                {
                    lifePoints = (int) (this.getLifePoints() / 2);
                }
            }
        } else {
            if (otherPerson.getType() == PeopleType.cleric) // help a peaceful friend
            {
                lifePoints = (int) (this.getLifePoints() - otherPerson.getLifePoints() / 2);
            } else {
                lifePoints = -1;
            }
        }
        return lifePoints;
    }
}