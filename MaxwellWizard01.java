public class MaxwellWizard01 extends People {

    MaxwellWizard01(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "Max's Wizard 1";
    }

    public int encounterStrategy(People otherPerson) {
        int lifePoints = 0;
        if (!this.getNation().equals(otherPerson.getNation())) {
            if (otherPerson.getLifePoints() < this.getLifePoints()) {
                if (otherPerson.getType() == PeopleType.wizard)
                {
                    lifePoints = this.getLifePoints();
                } else
                {
                    lifePoints = (int) (this.getLifePoints() / 3);
                }
            }
        } else {
            lifePoints = 0;
        }

        return lifePoints;
    }
}