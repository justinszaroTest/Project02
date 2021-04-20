/**
 * Maxwell Warrior 1 when encountered runs away because they shouldn't be in the war
 *
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 3.0
 * @since 2021-04-11
 */




public class MaxwellWarrior01 extends People {



    public MaxwellWarrior01(String nation, String tribe,  int lifePoints) {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription =  "\tMax's Warrior 01";
    }

    /**
     * attaks as normal when encountering everyone except a wizard. If encounters wizard then runs from encounter
     * @param otherPerson Other Person who is involved in the encounter
     * @return
     */
    @Override
    public int encounterStrategy(People otherPerson) {
        int numberOfLifePoints = 0;
        if(this.getNation().equals(otherPerson.getNation())){
            if(this.getLifePoints() > otherPerson.getLifePoints()) {
                if (otherPerson.getTribe().equals(this.getTribe())) {
                    numberOfLifePoints = -(this.getLifePoints()/2 - otherPerson.getLifePoints()-2);
                }
                else{
                    numberOfLifePoints = -(this.getLifePoints()/3 - otherPerson.getLifePoints()/2);

                }
            }

        }
        else{
            if(otherPerson.getType() == PeopleType.wizard){
                numberOfLifePoints = -(this.getLifePoints()); // I am running away because i shouldn't be in this war

            }
        }
        return numberOfLifePoints;
    }}
