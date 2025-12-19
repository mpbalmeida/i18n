package dev.marcosalmeida.i18n;

import com.neovisionaries.i18n.CountryCode;
import java.util.Arrays;
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

    /**
     * ISO-3166-2 subdivisions for Brazil.
     */
    enum BR implements Subdivision {
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

        /**
         * Returns the subdivision for the given code.
         *
         * @param code the ISO-3166-2 code.
         * @return the subdivision.
         * @throws IllegalArgumentException if no subdivision is found for the given code.
         */
        public static BR fromCode(String code) {
            return Arrays.stream(values())
                    .filter(s -> s.code.equalsIgnoreCase(code))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("No subdivision found for code: " + code));
        }
    }

    /**
     * ISO-3166-2 subdivisions for Mexico.
     */
    enum MX implements Subdivision {
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

        /**
         * Returns the subdivision for the given code.
         *
         * @param code the ISO-3166-2 code.
         * @return the subdivision.
         * @throws IllegalArgumentException if no subdivision is found for the given code.
         */
        public static MX fromCode(String code) {
            return Arrays.stream(values())
                    .filter(s -> s.code.equalsIgnoreCase(code))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("No subdivision found for code: " + code));
        }
    }

    /**
     * ISO-3166-2 subdivisions for the United States.
     */
    enum US implements Subdivision {
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

        /**
         * Returns the subdivision for the given code.
         *
         * @param code the ISO-3166-2 code.
         * @return the subdivision.
         * @throws IllegalArgumentException if no subdivision is found for the given code.
         */
        public static US fromCode(String code) {
            return Arrays.stream(values())
                    .filter(s -> s.code.equalsIgnoreCase(code))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("No subdivision found for code: " + code));
        }
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
        if (code == null || code.length() < 3) {
            throw new IllegalArgumentException("Invalid subdivision code: " + code);
        }

        return Stream.of(BR.values(), MX.values(), US.values())
                .flatMap(Arrays::stream)
                .filter(s -> s.getCode().equalsIgnoreCase(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No subdivision found for code: " + code));
    }
}
