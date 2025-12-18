package dev.marcosalmeida.i18n;

/**
 * ISO-3166-2 subdivisions for the United States.
 *
 * <p>
 * This includes 50 states, the District of Columbia, and 6 outlying areas.
 * </p>
 */
public enum SubdivisionUS implements Subdivision {
    /** Alabama (State) */
    AL("US-AL", "Alabama", "State"),
    /** Alaska (State) */
    AK("US-AK", "Alaska", "State"),
    /** Arizona (State) */
    AZ("US-AZ", "Arizona", "State"),
    /** Arkansas (State) */
    AR("US-AR", "Arkansas", "State"),
    /** California (State) */
    CA("US-CA", "California", "State"),
    /** Colorado (State) */
    CO("US-CO", "Colorado", "State"),
    /** Connecticut (State) */
    CT("US-CT", "Connecticut", "State"),
    /** Delaware (State) */
    DE("US-DE", "Delaware", "State"),
    /** Florida (State) */
    FL("US-FL", "Florida", "State"),
    /** Georgia (State) */
    GA("US-GA", "Georgia", "State"),
    /** Hawaii (State) */
    HI("US-HI", "Hawaii", "State"),
    /** Idaho (State) */
    ID("US-ID", "Idaho", "State"),
    /** Illinois (State) */
    IL("US-IL", "Illinois", "State"),
    /** Indiana (State) */
    IN("US-IN", "Indiana", "State"),
    /** Iowa (State) */
    IA("US-IA", "Iowa", "State"),
    /** Kansas (State) */
    KS("US-KS", "Kansas", "State"),
    /** Kentucky (State) */
    KY("US-KY", "Kentucky", "State"),
    /** Louisiana (State) */
    LA("US-LA", "Louisiana", "State"),
    /** Maine (State) */
    ME("US-ME", "Maine", "State"),
    /** Maryland (State) */
    MD("US-MD", "Maryland", "State"),
    /** Massachusetts (State) */
    MA("US-MA", "Massachusetts", "State"),
    /** Michigan (State) */
    MI("US-MI", "Michigan", "State"),
    /** Minnesota (State) */
    MN("US-MN", "Minnesota", "State"),
    /** Mississippi (State) */
    MS("US-MS", "Mississippi", "State"),
    /** Missouri (State) */
    MO("US-MO", "Missouri", "State"),
    /** Montana (State) */
    MT("US-MT", "Montana", "State"),
    /** Nebraska (State) */
    NE("US-NE", "Nebraska", "State"),
    /** Nevada (State) */
    NV("US-NV", "Nevada", "State"),
    /** New Hampshire (State) */
    NH("US-NH", "New Hampshire", "State"),
    /** New Jersey (State) */
    NJ("US-NJ", "New Jersey", "State"),
    /** New Mexico (State) */
    NM("US-NM", "New Mexico", "State"),
    /** New York (State) */
    NY("US-NY", "New York", "State"),
    /** North Carolina (State) */
    NC("US-NC", "North Carolina", "State"),
    /** North Dakota (State) */
    ND("US-ND", "North Dakota", "State"),
    /** Ohio (State) */
    OH("US-OH", "Ohio", "State"),
    /** Oklahoma (State) */
    OK("US-OK", "Oklahoma", "State"),
    /** Oregon (State) */
    OR("US-OR", "Oregon", "State"),
    /** Pennsylvania (State) */
    PA("US-PA", "Pennsylvania", "State"),
    /** Rhode Island (State) */
    RI("US-RI", "Rhode Island", "State"),
    /** South Carolina (State) */
    SC("US-SC", "South Carolina", "State"),
    /** South Dakota (State) */
    SD("US-SD", "South Dakota", "State"),
    /** Tennessee (State) */
    TN("US-TN", "Tennessee", "State"),
    /** Texas (State) */
    TX("US-TX", "Texas", "State"),
    /** Utah (State) */
    UT("US-UT", "Utah", "State"),
    /** Vermont (State) */
    VT("US-VT", "Vermont", "State"),
    /** Virginia (State) */
    VA("US-VA", "Virginia", "State"),
    /** Washington (State) */
    WA("US-WA", "Washington", "State"),
    /** West Virginia (State) */
    WV("US-WV", "West Virginia", "State"),
    /** Wisconsin (State) */
    WI("US-WI", "Wisconsin", "State"),
    /** Wyoming (State) */
    WY("US-WY", "Wyoming", "State"),
    /** District of Columbia (District) */
    DC("US-DC", "District of Columbia", "District"),
    /** American Samoa (Outlying area) */
    AS("US-AS", "American Samoa", "Outlying area"),
    /** Guam (Outlying area) */
    GU("US-GU", "Guam", "Outlying area"),
    /** Northern Mariana Islands (Outlying area) */
    MP("US-MP", "Northern Mariana Islands", "Outlying area"),
    /** Puerto Rico (Outlying area) */
    PR("US-PR", "Puerto Rico", "Outlying area"),
    /** United States Minor Outlying Islands (Outlying area) */
    UM("US-UM", "United States Minor Outlying Islands", "Outlying area"),
    /** Virgin Islands, U.S. (Outlying area) */
    VI("US-VI", "Virgin Islands, U.S.", "Outlying area");

    private final String code;
    private final String name;
    private final String category;

    SubdivisionUS(String code, String name, String category) {
        this.code = code;
        this.name = name;
        this.category = category;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getCategory() {
        return category;
    }
}
