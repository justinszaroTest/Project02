public class ElizabethHealer extends People {

    public ElizabethHealer(String nation, String tribe,  int lifePoints) {
        super(nation, tribe, PeopleType.cleric, lifePoints);
        myDescription =  "\tElizabeth Healer";
    }
    @Override
    public int encounterStrategy(People otherPerson) {
        int numberOfLifePoints = 0;
        if(this.getNation().equals(otherPerson.getNation())){ //if we're from the same nation
            if(this.getLifePoints() > otherPerson.getLifePoints()){ //if I have more lifePoints than them returning a negative value
                numberOfLifePoints = -(this.getLifePoints()/3);

            }
        }
        else{ //different nations
            if(otherPerson.getType() == PeopleType.wizard){
                numberOfLifePoints = -this.getLifePoints(); //when Liz Healer encounters wizard run away

            }
            else if(otherPerson.getType() == PeopleType.warrior) { //when Liz Healer encounters warrior run away
                numberOfLifePoints = -this.getLifePoints();

            }
            else if(otherPerson.getType() == PeopleType.cleric){ //when liz healer encounters healer fight with half
                numberOfLifePoints = this.getLifePoints()/2;
            }

        }
        return numberOfLifePoints;

    }
}
