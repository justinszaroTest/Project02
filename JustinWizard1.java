/**
 * The Justin Wizard 1 will fight harder if the type of the other person is a wizard. If the opponent is a member of
 * his tribe, he will use no lifepoints.
 *
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 3.0
 * @since 2021-04-11
 */

public class JustinWizard1 extends People {
    /**
     * Instantiates a JustinWizard1 Object and establishes its properties.
     * @param nation the nations name
     * @param tribe the tribes name
     * @param lifePoints the number of lifepoints
     */
    JustinWizard1(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription = "\tJustin Wizard";
    }
    /**
     * Returns the number of lifepoints to be used in the encounter.
     * @param otherPerson Other Person who is involved in the encounter
     * @return lifepoints number of lifepoints to be used in the encounter.
     */
    public int encounterStrategy(People otherPerson) {
        int lifePoints = 0;
        if (!this.getNation().equals(otherPerson.getNation())) {
            if (otherPerson.getLifePoints() < this.getLifePoints()) {
                if (otherPerson.getType() == PeopleType.wizard) // fight harder
                {
                    lifePoints = this.getLifePoints();
                } else // attack normal
                {
                    lifePoints = this.getLifePoints() / 2;
                }
            }
        }
        return lifePoints;
    }
}
