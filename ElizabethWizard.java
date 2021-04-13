public class ElizabethWizard extends People {


    public ElizabethWizard(String nation, String tribe,  int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription =  "\tElizabeth Wizard";
    }

    @Override
    public int encounterStrategy(People otherPerson) {
        int numberOfLifePoints = 0;
        if(this.getNation().equals(otherPerson.getNation())){ //if we're from the same nation
            if(this.getLifePoints() > otherPerson.getLifePoints()){ //if I have more lifePoints than them returning a negative value
                numberOfLifePoints = (otherPerson.getLifePoints()/3 - this.getLifePoints()/4);

            }
        }
        else{ //different nations
            if(otherPerson.getType() == PeopleType.wizard){
                numberOfLifePoints = (this.getLifePoints()/2)-3; //when Liz Wiz encounters wizard

            }
            else if(otherPerson.getType() == PeopleType.warrior) { //when Liz Wiz encounters wizard
                numberOfLifePoints = (this.getLifePoints()-10);

            }
            else if(otherPerson.getType() == PeopleType.cleric){
                numberOfLifePoints = this.getLifePoints();
            }

        }
        return numberOfLifePoints;
    }
}
