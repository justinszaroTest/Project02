/**
 * The Elizabeth Warrior is a warrior, that will fight an opponent warrior , heal their members, run from wizards and steal health from healers
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 3.0
 * @since 2021-04-11
 */
public class ElizabethWarrior extends People {


    public ElizabethWarrior(String nation, String tribe,  int lifePoints) {
        super(nation, tribe, PeopleType.warrior, lifePoints);
        myDescription =  "\tElizabeth Warrior";
    }

     /*** If we are from the same nation check our tribe and I have more life ponts than them, return a negative value
     * If we are from different nations
     *  Encounter Wizard- Run Away
     *  Encounter Warrior- Fight depending on who has more lifepoints
     *  Encounter Healer- Take all their health*/
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
                numberOfLifePoints = -(this.getLifePoints());
            }
            else if(otherPerson.getType() == PeopleType.warrior) {
                if(otherPerson.getLifePoints() > this.getLifePoints()){
                    numberOfLifePoints = this.getLifePoints() - otherPerson.getLifePoints();

                }
                else{
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

