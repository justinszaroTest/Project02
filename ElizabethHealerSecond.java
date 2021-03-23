public class ElizabethHealerSecond extends People {


    public ElizabethHealerSecond(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.cleric, lifePoints);
        myDescription = "\tElizabeth Healer Second";
    }

    @Override
    public int encounterStrategy(People otherPerson) {
        int numberOfLifePoints = 0;
        if(this.getNation() == otherPerson.getNation()){ //if we're from the same nation
            if(this.getLifePoints() > otherPerson.getLifePoints()){ //if I have more lifePoints than them returning a negative value
                numberOfLifePoints = -(this.getLifePoints()/10); //baby healing

            }
            else{
                numberOfLifePoints = 0;
            }

        }
        else{ //different nations
            if(otherPerson.getType() == PeopleType.wizard){
                numberOfLifePoints = this.getLifePoints()/2; //when Liz Healer encounters wizard tries to fight

            }
            else if(otherPerson.getType() == PeopleType.warrior) { //when Liz Healer encounters warrior give 50 lifepoints
                numberOfLifePoints = 50;

            }
            else if(otherPerson.getType() == PeopleType.cleric){ //when liz healer encounters healer fight with a quint of that
                numberOfLifePoints = this.getLifePoints()/5;
            }

        }
        return numberOfLifePoints;

    }
}


