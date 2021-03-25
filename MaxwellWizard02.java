public class MaxwellWizard02 extends People {


    public MaxwellWizard02(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "Max's wizard 02";
    }

    @Override
    public int encounterStrategy(People otherPerson) {
        int numberOfLifePoints = 0;
        if (this.getNation().equals(otherPerson.getNation())) {
            if (this.getLifePoints() > otherPerson.getLifePoints()) {
                numberOfLifePoints = -(otherPerson.getLifePoints() - 20);

            } else {
                numberOfLifePoints = 0;
            }

        } else { //different nations
            if (otherPerson.getType() == PeopleType.cleric) {
                numberOfLifePoints = (this.getLifePoints()) * 3; //when attacking cleric i do 3x damage

            } else if (otherPerson.getType() == PeopleType.warrior) {// i run from the warrior
                numberOfLifePoints = -(this.getLifePoints());

            } else if (otherPerson.getType() == PeopleType.wizard) {
                numberOfLifePoints = this.getLifePoints() - 40; //i heal for 40 points
            }

        }
        return numberOfLifePoints;
    }
}