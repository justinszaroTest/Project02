public class JustinWizard1 extends People {
    JustinWizard1(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tJustin Wizard";
    }

    public int encounterStrategy(People otherPerson) {
        int lifePoints = 0;
        if (this.getNation() != otherPerson.getNation()) {
            if (otherPerson.getLifePoints() < this.getLifePoints()) {
                if (otherPerson.getType() == PeopleType.wizard) // fight harder
                {
                    lifePoints = this.getLifePoints();
                } else // attack normal
                {
                    lifePoints = (int) (this.getLifePoints() / 2);
                }
            }
        } else {
            lifePoints = 0;
        }
        return lifePoints;
    }
}
