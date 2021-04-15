public class ElizabethHealer extends People {

    public ElizabethHealer(String nation, String tribe,  int lifePoints) {
        super(nation, tribe, PeopleType.cleric, lifePoints);
        myDescription =  "\tElizabeth Healer";
    }
    /*** If we are from the same nation and I have more life ponts than them, return a negative value
     * If we are from different nations
     *  Encounter Wizard- Run Away
     *  Encounter Warrior- Run Away
     *  Encounter Healer- Fight with half*/
    @Override
    public int encounterStrategy(People otherPerson) {
        int numberOfLifePoints = 0;
        if(this.getNation().equals(otherPerson.getNation())){
            if(this.getLifePoints() > otherPerson.getLifePoints()){
                numberOfLifePoints = -(this.getLifePoints()/3);

            }
        }
        else{
            if(otherPerson.getType() == PeopleType.wizard){
                numberOfLifePoints = -this.getLifePoints();
            }
            else if(otherPerson.getType() == PeopleType.warrior) {
                numberOfLifePoints = -this.getLifePoints();

            }
            else if(otherPerson.getType() == PeopleType.cleric){
                numberOfLifePoints = this.getLifePoints()/2;
            }

        }
        return numberOfLifePoints;

    }
}
