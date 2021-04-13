public class ElizabethWarrior extends People {


    public ElizabethWarrior(String nation, String tribe,  int lifePoints) {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription =  "\tElizabeth Warrior";
    }

    @Override
    public int encounterStrategy(People otherPerson) {
        int numberOfLifePoints = 0;
        if(this.getNation().equals(otherPerson.getNation())){ //if we're from the same nation
            if(this.getLifePoints() > otherPerson.getLifePoints()) { //if I have more lifePoints than them returning a negative value
                if (otherPerson.getTribe().equals(this.getTribe())) { //we are from the same tribe
                    numberOfLifePoints = -(this.getLifePoints()/2 - otherPerson.getLifePoints()-2);
                }
                else{ //not from the same tribe
                    numberOfLifePoints = -(this.getLifePoints()/3 - otherPerson.getLifePoints()/2);

                }
            }

        }
        else{ //different nations
            if(otherPerson.getType() == PeopleType.wizard){
                numberOfLifePoints = -(this.getLifePoints()); //when Liz war encounters wizard - run away

            }
            else if(otherPerson.getType() == PeopleType.warrior) { //when Liz warrior encounters warrior
                if(otherPerson.getLifePoints() > this.getLifePoints()){ //if the other warrior has more life points
                    numberOfLifePoints = this.getLifePoints() - otherPerson.getLifePoints();

                }
                else{ //i have more or equal points
                    numberOfLifePoints = this.getLifePoints() - 5 + otherPerson.getLifePoints()/4;
                }


            }
            else if(otherPerson.getType() == PeopleType.cleric){
                numberOfLifePoints = this.getLifePoints();
            }

        }
        return numberOfLifePoints;
    }
}

