public class ElizabethWarriorSecond  extends People{

    public ElizabethWarriorSecond(String nation, String tribe,  int lifePoints) {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription =  "\tELizabeth Warrior Second";
    }

    @Override
    public int encounterStrategy(People otherPerson) {
        int numberOfLifePoints = 0;
        if(this.getNation() == otherPerson.getNation()){ //if we're from the same nation
            if(this.getLifePoints() > otherPerson.getLifePoints()){ //if I have more lifePoints than them returning a negative value
                numberOfLifePoints = (otherPerson.getLifePoints()/5 - this.getLifePoints()/10);

            }
            else{
                numberOfLifePoints = 0;
            }

        }
        else{ //different nations
            if(otherPerson.getType() == PeopleType.wizard){
                numberOfLifePoints = (this.getLifePoints())-65; //when Liz Warrior encounters wizard

            }
            else if(otherPerson.getType() == PeopleType.warrior) { //when Liz Warrior encounters Warrior
                numberOfLifePoints = (this.getLifePoints()/3);

            }
            else if(otherPerson.getType() == PeopleType.cleric){ //other healer give them all
                numberOfLifePoints = this.getLifePoints();
            }

        }
        return numberOfLifePoints;
    }
}
