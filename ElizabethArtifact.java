/**
 * The Elizabeth Artificat is an angel, based on the type and dice value, the angel will heal
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 3.0
 * @since 2021-04-11
 */
public class ElizabethArtifact extends People {
    public ElizabethArtifact(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.angel, lifePoints, "Angel");
        myDescription = "\tAngel Heals a player!";
        turnsAvailable = lifePoints;
    }

    private int turnsAvailable;

    /**
     * If we are from different nations. If its a wizard and the lifepoint is divisible by 3 set a certain life point of
     * numberOfLifePoints = otherPerson.getLifePoints() * damageValue; as well as  this lifePoint (turnsAvailable) --;
     * Other wise Modify the opponents lifepoints to be .modifyLifePoints(diceRollOfTurn.rollFaces(4) * turnsAvailable);
     * <p>
     * If its a warrior. If its divisible by 2, get a certain lifepoint by int damageValue = diceRollOfTurn.rollFaces(10);
     * numberOfLifePoints = (int) Math.pow(otherPerson.getLifePoints(), damageValue); as well as  this lifePoint (turnsAvailable) --;
     * Not divisible by 2, then subtract one opponent life point by 1 at most 20 times.
     * <p>
     * If its a cleric, set  this lifePoint (turnsAvailable) to 100 and return complete health
     */
    @Override
    public int encounterStrategy(People otherPerson) {
        int numberOfLifePoints = 100;
        Dice diceRollOfTurn = new Dice();
                //different nations
            if (otherPerson.getType() == PeopleType.wizard) {
                if (turnsAvailable + otherPerson.getLifePoints() % 3 == 0) {
                    int damageValue = diceRollOfTurn.rollFaces(15);
                    numberOfLifePoints = otherPerson.getLifePoints() * damageValue;
                    turnsAvailable++;
                }
                otherPerson.modifyLifePoints(diceRollOfTurn.rollFaces(4) * turnsAvailable);
            } else if (otherPerson.getType() == PeopleType.warrior) {
                if (turnsAvailable * otherPerson.getLifePoints() % 2 == 0) {
                    int damageValue = diceRollOfTurn.rollFaces(10);
                    numberOfLifePoints = (int) Math.pow(otherPerson.getLifePoints(), damageValue);
                    turnsAvailable++;

                } else {
                    int howManyTimesToGo = diceRollOfTurn.rollFaces(20);
                    while (howManyTimesToGo != 0) {
                        int lifePoints = otherPerson.getLifePoints() - 1;
                        otherPerson.modifyLifePoints(lifePoints);
                        howManyTimesToGo--;
                    }

                    numberOfLifePoints *= howManyTimesToGo;
                }
            } else if (otherPerson.getType() == PeopleType.cleric) {
                numberOfLifePoints = -100;
                while (turnsAvailable <= 100) {
                    turnsAvailable++;
                }

            }

        return numberOfLifePoints;
    }

}
