/**
 * This class sets the description for an instantiated Person in the People class based on its type.
 * The class also includes the getter for a Person's description.
 *
 * @author Max Schuman, Elizabeth Vicente, Tanishq Iyer, Justin Szaro
 * @version 3.0
 * @since 2021-04-11
 */
public enum PeopleType
{
    wizard  ("wizard"),
    warrior ("warrior"),
    cleric ("Healer"),
    angel ("Angel"),
    reaper ("Death"),
    TheFlash("The Flash");



    private final String description;

    /**
     *Sets the description of the Person to its type.
     * @param types The type of Person.
     */
    PeopleType (String types)
    {
        description = types;
    }

    /**
     * Returns the Players established description.
     * @return description
     */
    public String getDescription()
    {
        return description;
    }
}
