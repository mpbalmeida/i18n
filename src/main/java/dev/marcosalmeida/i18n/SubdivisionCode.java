package dev.marcosalmeida.i18n;

import com.neovisionaries.i18n.CountryCode;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Entry point for accessing ISO-3166-2 subdivisions.
 *
 * <p>
 * This class provides access to subdivisions for various countries using the syntax
 * {@code SubdivisionCode.COUNTRY.SUBDIVISION} (e.g., {@code SubdivisionCode.US.AL}).
 * </p>
 */
public final class SubdivisionCode {

    private SubdivisionCode() {
        // Prevent instantiation
    }

    private static <T extends Subdivision> T fromCode(T[] values, String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Invalid subdivision code: " + code);
        }
        return Arrays.stream(values)
                .filter(s -> s.getCode().equalsIgnoreCase(code) || s.getSubdivisionCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No subdivision found for code: " + code));
    }

    private static <T extends Subdivision> Optional<Subdivision> fromName(T[] values, String name) {
        if (name == null || name.isBlank()) {
            return Optional.empty();
        }
        String normalized = name.trim();
        return Arrays.stream(values)
                .filter(s -> s.getName().equalsIgnoreCase(normalized))
                .map(Subdivision.class::cast)
                .findFirst();
    }

    private static <T extends Subdivision> Optional<Subdivision> find(T[] values, String value) {
        if (value == null || value.isBlank()) {
            return Optional.empty();
        }

        try {
            return Optional.of(fromCode(values, value));
        } catch (IllegalArgumentException e) {
            return fromName(values, value);
        }
    }

    private static <T extends Subdivision> Subdivision[] getByCategory(T[] values, String category) {
        if (category == null || category.isBlank()) {
            return new Subdivision[0];
        }
        return Arrays.stream(values)
                .filter(s -> s.getCategory().equalsIgnoreCase(category))
                .toArray(Subdivision[]::new);
    }

    private static <T extends Subdivision> Subdivision[] getByParent(T[] values, Subdivision parent) {
        if (parent == null) {
            return new Subdivision[0];
        }
        return Arrays.stream(values)
                .filter(s -> s.getParent().map(p -> p.equals(parent)).orElse(false))
                .toArray(Subdivision[]::new);
    }

    /**
     * ISO-3166-2 subdivisions for Brazil.
     */
    public enum BR implements Subdivision {
        /** Acre (state) */
        AC("BR-AC", "Acre", "state"),
        /** Alagoas (state) */
        AL("BR-AL", "Alagoas", "state"),
        /** Amapá (state) */
        AP("BR-AP", "Amapá", "state"),
        /** Amazonas (state) */
        AM("BR-AM", "Amazonas", "state"),
        /** Bahia (state) */
        BA("BR-BA", "Bahia", "state"),
        /** Ceará (state) */
        CE("BR-CE", "Ceará", "state"),
        /** Distrito Federal (federal district) */
        DF("BR-DF", "Distrito Federal", "federal district"),
        /** Espírito Santo (state) */
        ES("BR-ES", "Espírito Santo", "state"),
        /** Goiás (state) */
        GO("BR-GO", "Goiás", "state"),
        /** Maranhão (state) */
        MA("BR-MA", "Maranhão", "state"),
        /** Mato Grosso (state) */
        MT("BR-MT", "Mato Grosso", "state"),
        /** Mato Grosso do Sul (state) */
        MS("BR-MS", "Mato Grosso do Sul", "state"),
        /** Minas Gerais (state) */
        MG("BR-MG", "Minas Gerais", "state"),
        /** Pará (state) */
        PA("BR-PA", "Pará", "state"),
        /** Paraíba (state) */
        PB("BR-PB", "Paraíba", "state"),
        /** Paraná (state) */
        PR("BR-PR", "Paraná", "state"),
        /** Pernambuco (state) */
        PE("BR-PE", "Pernambuco", "state"),
        /** Piauí (state) */
        PI("BR-PI", "Piauí", "state"),
        /** Rio de Janeiro (state) */
        RJ("BR-RJ", "Rio de Janeiro", "state"),
        /** Rio Grande do Norte (state) */
        RN("BR-RN", "Rio Grande do Norte", "state"),
        /** Rio Grande do Sul (state) */
        RS("BR-RS", "Rio Grande do Sul", "state"),
        /** Rondônia (state) */
        RO("BR-RO", "Rondônia", "state"),
        /** Roraima (state) */
        RR("BR-RR", "Roraima", "state"),
        /** Santa Catarina (state) */
        SC("BR-SC", "Santa Catarina", "state"),
        /** São Paulo (state) */
        SP("BR-SP", "São Paulo", "state"),
        /** Sergipe (state) */
        SE("BR-SE", "Sergipe", "state"),
        /** Tocantins (state) */
        TO("BR-TO", "Tocantins", "state");

        private final String code;
        private final String name;
        private final String category;

        BR(String code, String name, String category) {
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

        @Override
        public String getSubdivisionCode() {
            return name();
        }

        @Override
        public Optional<Subdivision> getParent() {
            return Optional.empty();
        }

        /**
         * Returns the subdivision for the given code.
         *
         * @param code the ISO-3166-2 code or subdivision code part.
         * @return the subdivision.
         * @throws IllegalArgumentException if no subdivision is found for the given code.
         */
        public static BR fromCode(String code) {
            return SubdivisionCode.fromCode(values(), code);
        }

        /**
         * Returns the subdivision for the given name.
         *
         * @param name the subdivision name.
         * @return an Optional containing the subdivision if found, or empty otherwise.
         */
        public static Optional<Subdivision> fromName(String name) {
            return SubdivisionCode.fromName(values(), name);
        }

        /**
         * Returns the subdivision for the given value, searching by code or name.
         *
         * @param value the code or name.
         * @return an Optional containing the subdivision if found, or empty otherwise.
         */
        public static Optional<Subdivision> find(String value) {
            return SubdivisionCode.find(values(), value);
        }

        /**
         * Returns the Brazilian states.
         *
         * @return an array of states.
         */
        public static Subdivision[] getStates() {
            return SubdivisionCode.getByCategory(values(), "state");
        }

        /**
         * Returns the Brazilian federal districts.
         *
         * @return an array of federal districts.
         */
        public static Subdivision[] getFederalDistricts() {
            return SubdivisionCode.getByCategory(values(), "federal district");
        }
    }

    /**
     * ISO-3166-2 subdivisions for Ireland.
     */
    public enum IE implements Subdivision {
        /** Connaught (province) */
        C("IE-C", "Connaught", "province", null),
        /** Leinster (province) */
        L("IE-L", "Leinster", "province", null),
        /** Munster (province) */
        M("IE-M", "Munster", "province", null),
        /** Ulster (province) */
        U("IE-U", "Ulster", "province", null),
        /** Carlow (county) */
        CW("IE-CW", "Carlow", "county", L),
        /** Cavan (county) */
        CN("IE-CN", "Cavan", "county", U),
        /** Clare (county) */
        CE("IE-CE", "Clare", "county", M),
        /** Cork (county) */
        CO("IE-CO", "Cork", "county", M),
        /** Donegal (county) */
        DL("IE-DL", "Donegal", "county", U),
        /** Dublin (county) */
        D("IE-D", "Dublin", "county", L),
        /** Galway (county) */
        G("IE-G", "Galway", "county", C),
        /** Kerry (county) */
        KY("IE-KY", "Kerry", "county", M),
        /** Kildare (county) */
        KE("IE-KE", "Kildare", "county", L),
        /** Kilkenny (county) */
        KK("IE-KK", "Kilkenny", "county", L),
        /** Laois (county) */
        LS("IE-LS", "Laois", "county", L),
        /** Leitrim (county) */
        LM("IE-LM", "Leitrim", "county", C),
        /** Limerick (county) */
        LK("IE-LK", "Limerick", "county", M),
        /** Longford (county) */
        LD("IE-LD", "Longford", "county", L),
        /** Louth (county) */
        LH("IE-LH", "Louth", "county", L),
        /** Mayo (county) */
        MO("IE-MO", "Mayo", "county", C),
        /** Meath (county) */
        MH("IE-MH", "Meath", "county", L),
        /** Monaghan (county) */
        MN("IE-MN", "Monaghan", "county", U),
        /** Offaly (county) */
        OY("IE-OY", "Offaly", "county", L),
        /** Roscommon (county) */
        RN("IE-RN", "Roscommon", "county", C),
        /** Sligo (county) */
        SO("IE-SO", "Sligo", "county", C),
        /** Tipperary (county) */
        TA("IE-TA", "Tipperary", "county", M),
        /** Waterford (county) */
        WD("IE-WD", "Waterford", "county", M),
        /** Westmeath (county) */
        WH("IE-WH", "Westmeath", "county", L),
        /** Wexford (county) */
        WX("IE-WX", "Wexford", "county", L),
        /** Wicklow (county) */
        WW("IE-WW", "Wicklow", "county", L);

        private final String code;
        private final String name;
        private final String category;
        private final IE parent;

        IE(String code, String name, String category, IE parent) {
            this.code = code;
            this.name = name;
            this.category = category;
            this.parent = parent;
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

        @Override
        public String getSubdivisionCode() {
            return name();
        }

        @Override
        public Optional<Subdivision> getParent() {
            return Optional.ofNullable(parent);
        }

        /**
         * Returns the subdivision for the given code.
         *
         * @param code the ISO-3166-2 code or subdivision code part.
         * @return the subdivision.
         * @throws IllegalArgumentException if no subdivision is found for the given code.
         */
        public static IE fromCode(String code) {
            return SubdivisionCode.fromCode(values(), code);
        }

        /**
         * Returns the subdivision for the given name.
         *
         * @param name the subdivision name.
         * @return an Optional containing the subdivision if found, or empty otherwise.
         */
        public static Optional<Subdivision> fromName(String name) {
            return SubdivisionCode.fromName(values(), name);
        }

        /**
         * Returns the subdivision for the given value, searching by code or name.
         *
         * @param value the code or name.
         * @return an Optional containing the subdivision if found, or empty otherwise.
         */
        public static Optional<Subdivision> find(String value) {
            return SubdivisionCode.find(values(), value);
        }

        /**
         * Returns the Irish provinces.
         *
         * @return an array of provinces.
         */
        public static Subdivision[] getProvinces() {
            return SubdivisionCode.getByCategory(values(), "province");
        }

        /**
         * Returns the Irish counties.
         *
         * @return an array of counties.
         */
        public static Subdivision[] getCounties() {
            return SubdivisionCode.getByCategory(values(), "county");
        }

        /**
         * Returns the subdivisions for the given parent.
         *
         * @param parent the parent subdivision.
         * @return an array of subdivisions belonging to the parent.
         */
        public static Subdivision[] getByParent(Subdivision parent) {
            return SubdivisionCode.getByParent(values(), parent);
        }
    }

    /**
     * ISO-3166-2 subdivisions for Mexico.
     */
    public enum MX implements Subdivision {
        /** Aguascalientes (state) */
        AGU("MX-AGU", "Aguascalientes", "state"),
        /** Baja California (state) */
        BCN("MX-BCN", "Baja California", "state"),
        /** Baja California Sur (state) */
        BCS("MX-BCS", "Baja California Sur", "state"),
        /** Campeche (state) */
        CAM("MX-CAM", "Campeche", "state"),
        /** Chiapas (state) */
        CHP("MX-CHP", "Chiapas", "state"),
        /** Chihuahua (state) */
        CHH("MX-CHH", "Chihuahua", "state"),
        /** Ciudad de México (federal entity) */
        CMX("MX-CMX", "Ciudad de México", "federal entity"),
        /** Coahuila de Zaragoza (state) */
        COA("MX-COA", "Coahuila de Zaragoza", "state"),
        /** Colima (state) */
        COL("MX-COL", "Colima", "state"),
        /** Durango (state) */
        DUR("MX-DUR", "Durango", "state"),
        /** Guanajuato (state) */
        GUA("MX-GUA", "Guanajuato", "state"),
        /** Guerrero (state) */
        GRO("MX-GRO", "Guerrero", "state"),
        /** Hidalgo (state) */
        HID("MX-HID", "Hidalgo", "state"),
        /** Jalisco (state) */
        JAL("MX-JAL", "Jalisco", "state"),
        /** Michoacán de Ocampo (state) */
        MIC("MX-MIC", "Michoacán de Ocampo", "state"),
        /** Morelos (state) */
        MOR("MX-MOR", "Morelos", "state"),
        /** México (state) */
        MEX("MX-MEX", "México", "state"),
        /** Nayarit (state) */
        NAY("MX-NAY", "Nayarit", "state"),
        /** Nuevo León (state) */
        NLE("MX-NLE", "Nuevo León", "state"),
        /** Oaxaca (state) */
        OAX("MX-OAX", "Oaxaca", "state"),
        /** Puebla (state) */
        PUE("MX-PUE", "Puebla", "state"),
        /** Querétaro (state) */
        QUE("MX-QUE", "Querétaro", "state"),
        /** Quintana Roo (state) */
        ROO("MX-ROO", "Quintana Roo", "state"),
        /** San Luis Potosí (state) */
        SLP("MX-SLP", "San Luis Potosí", "state"),
        /** Sinaloa (state) */
        SIN("MX-SIN", "Sinaloa", "state"),
        /** Sonora (state) */
        SON("MX-SON", "Sonora", "state"),
        /** Tabasco (state) */
        TAB("MX-TAB", "Tabasco", "state"),
        /** Tamaulipas (state) */
        TAM("MX-TAM", "Tamaulipas", "state"),
        /** Tlaxcala (state) */
        TLA("MX-TLA", "Tlaxcala", "state"),
        /** Veracruz de Ignacio de la Llave (state) */
        VER("MX-VER", "Veracruz de Ignacio de la Llave", "state"),
        /** Yucatán (state) */
        YUC("MX-YUC", "Yucatán", "state"),
        /** Zacatecas (state) */
        ZAC("MX-ZAC", "Zacatecas", "state");

        private final String code;
        private final String name;
        private final String category;

        MX(String code, String name, String category) {
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

        @Override
        public String getSubdivisionCode() {
            return name();
        }

        @Override
        public Optional<Subdivision> getParent() {
            return Optional.empty();
        }

        /**
         * Returns the subdivision for the given code.
         *
         * @param code the ISO-3166-2 code or subdivision code part.
         * @return the subdivision.
         * @throws IllegalArgumentException if no subdivision is found for the given code.
         */
        public static MX fromCode(String code) {
            return SubdivisionCode.fromCode(values(), code);
        }

        /**
         * Returns the subdivision for the given name.
         *
         * @param name the subdivision name.
         * @return an Optional containing the subdivision if found, or empty otherwise.
         */
        public static Optional<Subdivision> fromName(String name) {
            return SubdivisionCode.fromName(values(), name);
        }

        /**
         * Returns the subdivision for the given value, searching by code or name.
         *
         * @param value the code or name.
         * @return an Optional containing the subdivision if found, or empty otherwise.
         */
        public static Optional<Subdivision> find(String value) {
            return SubdivisionCode.find(values(), value);
        }

        /**
         * Returns the Mexican states.
         *
         * @return an array of states.
         */
        public static Subdivision[] getStates() {
            return SubdivisionCode.getByCategory(values(), "state");
        }

        /**
         * Returns the Mexican federal entities.
         *
         * @return an array of federal entities.
         */
        public static Subdivision[] getFederalEntities() {
            return SubdivisionCode.getByCategory(values(), "federal entity");
        }

        /**
         * Returns the subdivisions for the given parent.
         *
         * @param parent the parent subdivision.
         * @return an array of subdivisions belonging to the parent.
         */
        public static Subdivision[] getByParent(Subdivision parent) {
            return SubdivisionCode.getByParent(values(), parent);
        }
    }

    /**
     * ISO-3166-2 subdivisions for the United States.
     */
    public enum US implements Subdivision {
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

        US(String code, String name, String category) {
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

        @Override
        public String getSubdivisionCode() {
            return name();
        }

        @Override
        public Optional<Subdivision> getParent() {
            return Optional.empty();
        }

        /**
         * Returns the subdivision for the given code.
         *
         * @param code the ISO-3166-2 code or subdivision code part.
         * @return the subdivision.
         * @throws IllegalArgumentException if no subdivision is found for the given code.
         */
        public static US fromCode(String code) {
            return SubdivisionCode.fromCode(values(), code);
        }

        /**
         * Returns the subdivision for the given name.
         *
         * @param name the subdivision name.
         * @return an Optional containing the subdivision if found, or empty otherwise.
         */
        public static Optional<Subdivision> fromName(String name) {
            return SubdivisionCode.fromName(values(), name);
        }

        /**
         * Returns the subdivision for the given value, searching by code or name.
         *
         * @param value the code or name.
         * @return an Optional containing the subdivision if found, or empty otherwise.
         */
        public static Optional<Subdivision> find(String value) {
            return SubdivisionCode.find(values(), value);
        }

        /**
         * Returns the US states.
         *
         * @return an array of states.
         */
        public static Subdivision[] getStates() {
            return SubdivisionCode.getByCategory(values(), "State");
        }

        /**
         * Returns the US districts.
         *
         * @return an array of districts.
         */
        public static Subdivision[] getDistricts() {
            return SubdivisionCode.getByCategory(values(), "District");
        }

        /**
         * Returns the US outlying areas.
         *
         * @return an array of outlying areas.
         */
        public static Subdivision[] getOutlyingAreas() {
            return SubdivisionCode.getByCategory(values(), "Outlying area");
        }
    }

    private static Subdivision[] allValues() {
        return Stream.of(BR.values(), IE.values(), MX.values(), US.values())
                .flatMap(Arrays::stream)
                .toArray(Subdivision[]::new);
    }

    /**
     * Gets subdivisions by country code.
     *
     * @param code the country code.
     * @return an array of subdivisions for the country, or null if not supported.
     */
    public static Subdivision[] getSubdivisions(CountryCode code) {
        if (code == null) return null;
        return switch (code) {
            case BR -> BR.values();
            case IE -> IE.values();
            case MX -> MX.values();
            case US -> US.values();
            default -> null;
        };
    }

    /**
     * Gets a subdivision by its ISO-3166-2 code.
     *
     * @param code the ISO-3166-2 code (e.g., "US-AL").
     * @return the subdivision.
     * @throws IllegalArgumentException if the code is invalid or not supported.
     */
    public static Subdivision fromCode(String code) {
        return fromCode(allValues(), code);
    }

    /**
     * Returns the subdivision for the given name.
     *
     * @param name the subdivision name.
     * @return an Optional containing the subdivision if found, or empty otherwise.
     */
    public static Optional<Subdivision> fromName(String name) {
        return fromName(allValues(), name);
    }

    /**
     * Returns the subdivision for the given value, searching by code or name across all countries.
     *
     * @param value the code or name.
     * @return an Optional containing the subdivision if found, or empty otherwise.
     */
    public static Optional<Subdivision> find(String value) {
        return find(allValues(), value);
    }

    /**
     * Returns all states across supported countries.
     *
     * @return an array of states.
     */
    public static Subdivision[] getStates() {
        return Stream.concat(
                Arrays.stream(BR.getStates()),
                Stream.concat(Arrays.stream(MX.getStates()), Arrays.stream(US.getStates()))
        ).toArray(Subdivision[]::new);
    }

    /**
     * Returns all provinces across supported countries.
     *
     * @return an array of provinces.
     */
    public static Subdivision[] getProvinces() {
        return IE.getProvinces();
    }

    /**
     * Returns all counties across supported countries.
     *
     * @return an array of counties.
     */
    public static Subdivision[] getCounties() {
        return IE.getCounties();
    }

    /**
     * Returns the subdivisions for the given parent across all countries.
     *
     * @param parent the parent subdivision.
     * @return an array of subdivisions belonging to the parent.
     */
    public static Subdivision[] getByParent(Subdivision parent) {
        return getByParent(allValues(), parent);
    }
}
