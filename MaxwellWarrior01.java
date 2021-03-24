public class MaxwellWarrior01 extends People {



    public MaxwellWarrior01(String nation, String tribe,  int lifePoints) {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription =  "Max's Warrior 01";
    }

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
                numberOfLifePoints = -(this.getLifePoints()); // I am running away becuase i shouldnt be in this war

            }
        }
        return numberOfLifePoints;
    }}
