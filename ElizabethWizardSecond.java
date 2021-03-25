public class ElizabethWizardSecond extends People {

    public ElizabethWizardSecond(String nation, String tribe,  int lifePoints) {
        super(nation, tribe, PeopleType.wizard, lifePoints);
        myDescription =  "\tElizabeth Wizard Second";
    }

    @Override
    public int encounterStrategy(People otherPerson) {
        int numberOfLifePoints = 0;
        if(this.getNation() == otherPerson.getNation()){ //if we're from the same nation
            if(this.getLifePoints() > otherPerson.getLifePoints()){ //if I have more lifePoints than them returning a negative value
                numberOfLifePoints = -(otherPerson.getLifePoints() - 20);

            }
            else{
                numberOfLifePoints = 0;
            }

        }
        else{ //different nations
            if(otherPerson.getType() == PeopleType.wizard){
                numberOfLifePoints = (this.getLifePoints() )*2; //when Liz Wiz encounters wizard

            }
            else if(otherPerson.getType() == PeopleType.warrior) { //when Liz Wiz encounters Warrior run away
                numberOfLifePoints = -(this.getLifePoints());

            }
            else if(otherPerson.getType() == PeopleType.cleric){
                numberOfLifePoints = this.getLifePoints()-4;
            }

        }
        return numberOfLifePoints;
    }
}
