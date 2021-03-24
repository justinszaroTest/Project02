public class MaxwellHealer02 extends People {


    public MaxwellHealer02(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.cleric, lifePoints);
        myDescription = "\tMax's Healer 02";
    }

    @Override
    public int encounterStrategy(People otherPerson) {
        int numberOfLifePoints = 0;
        if(this.getNation().equals(otherPerson.getNation())){
            if(this.getLifePoints() > otherPerson.getLifePoints()){
                numberOfLifePoints = -(this.getLifePoints()/10);

            }
            else{
                numberOfLifePoints = 0;
            }

        }
        else{
            if(otherPerson.getType() == PeopleType.warrior){ //I will attack
                numberOfLifePoints = this.getLifePoints()/2;

            }
            else if(otherPerson.getType() == PeopleType.wizard) { //I will heal
                numberOfLifePoints = 50;

            }
            else if(otherPerson.getType() == PeopleType.cleric){ //I will do my best
                numberOfLifePoints = this.getLifePoints()/5;
            }

        }
        return numberOfLifePoints;

    }
}


