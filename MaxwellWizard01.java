/**
 * The Wizard 1 if they encounter another wizard they do 3x the damage
 *
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 3.0
 * @since 2021-04-11
 */


public class MaxwellWizard01 extends People {

    MaxwellWizard01(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tMax's Wizard 01";
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
                    lifePoints = this.getLifePoints() / 3;
                }
            }
        }
        return lifePoints;
    }
}