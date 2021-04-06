public class ElizabethArtifact extends People {
    public ElizabethArtifact(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.angel, lifePoints);
        myDescription = "\tAngel Special Character";
        turnsAvailable = lifePoints;
    }

    private int turnsAvailable;

    /**
     * If we are from the same class than compares the life points. If its less than 75 make it full else
     * -(numberOfLifePoints / diceRollOfTurn.rollFaces(6)). Subratract one life point
     * <p>
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
        if (this.getNation().equals(otherPerson.getNation())) { //if we're from the same nation
            if (75 >= otherPerson.getLifePoints()) { //if I have more lifePoints than them returning a negative value
                numberOfLifePoints = -100;
            } else {
                numberOfLifePoints = -(numberOfLifePoints / diceRollOfTurn.rollFaces(6));
            }
            turnsAvailable--;
        } else { //different nations
            if (otherPerson.getType() == PeopleType.wizard) {
                if (turnsAvailable % 3 == 0) {
                    int damageValue = diceRollOfTurn.rollFaces(15);
                    numberOfLifePoints = otherPerson.getLifePoints() * damageValue;
                    turnsAvailable--;
                }
                otherPerson.modifyLifePoints(diceRollOfTurn.rollFaces(4) * turnsAvailable);
            } else if (otherPerson.getType() == PeopleType.warrior) {
                if (turnsAvailable % 2 == 0) {
                    int damageValue = diceRollOfTurn.rollFaces(10);
                    numberOfLifePoints = (int) Math.pow(otherPerson.getLifePoints(), damageValue);
                    turnsAvailable--;
                } else {
                    int howManyTimesToGo = diceRollOfTurn.rollFaces(20);
                    while (howManyTimesToGo != 0) {
                        int lifePoints = otherPerson.getLifePoints() - 1;
                        otherPerson.modifyLifePoints(lifePoints);
                        howManyTimesToGo--;
                    }
                }
            } else if (otherPerson.getType() == PeopleType.cleric) {
                numberOfLifePoints = -100;
                while (turnsAvailable <= 100) {
                    turnsAvailable++;
                }

            }

        }
        return numberOfLifePoints;
    }

}
