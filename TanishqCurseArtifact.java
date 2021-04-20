/**
 * This class represents a Curse Artifact.
 */
public class TanishqCurseArtifact extends People {
    public static final int MAX_DAMAGE = 123456789;
    private final Dice dice;

    /**
     * Constructs a curse artifact.
     * @param nation nation's name.
     * @param tribe tribe's name.
     * @param lifePoints life points for this artifact.
     */
    public TanishqCurseArtifact(String nation, String tribe, int lifePoints) {
        super(nation, tribe, PeopleType.curse, lifePoints);

        myDescription = "\tCursed Artifact";
        dice = new Dice();
    }

    /**
     * Implements Encounter Strategy for the Cursed Artifact.
     * @param other the friend or enemy in the encounter.
     * @return positive for damage, negative for healing.
     */
    @Override
    public int encounterStrategy(People other) {
        boolean isSameNation = this.getNation().equals(other.getNation());
        return isSameNation ?
                sameNationStrategy(other) :
                differentNationStrategy(other);
    }

    /**
     * Strategy for same nation does nothing.
     * @param friend the person from the same nation.
     * @return always 0.
     */
    private int sameNationStrategy(People friend) {
        return 0;
    }

    /**
     * Strategy for a different nation.
     * 1% chance of dealing max damage to a cleric.
     * 5% chance of dealing max damage to a wizard.
     * 15% chance of dealing max damage to a warrior.
     * doesn't deal damage to any other type.
     * @param enemy the enemy People object.
     * @return the amount of damage.
     */
    private int differentNationStrategy(People enemy) {
        float roll = dice.roll();

        return switch (enemy.getType()) {
            case cleric -> roll < 0.01 ? MAX_DAMAGE : 0;
            case wizard -> roll < 0.05 ? MAX_DAMAGE : 0;
            case warrior -> roll < 0.15 ? MAX_DAMAGE : 0;
            default -> 0;
        };
    }
}
