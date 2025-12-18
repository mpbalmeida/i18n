package dev.marcosalmeida.i18n;

import com.neovisionaries.i18n.CountryCode;
import java.util.Arrays;

/**
 * Enumeration of countries that have ISO-3166-2 subdivisions implemented in this library.
 */
public enum SubdivisionCode {
    /**
     * Brazil.
     */
    BR(CountryCode.BR, SubdivisionBR.class),

    /**
     * Mexico.
     */
    MX(CountryCode.MX, SubdivisionMX.class),

    /**
     * United States.
     */
    US(CountryCode.US, SubdivisionUS.class);

    private final CountryCode countryCode;
    private final Class<? extends Subdivision> subdivisionClass;

    SubdivisionCode(CountryCode countryCode, Class<? extends Subdivision> subdivisionClass) {
        this.countryCode = countryCode;
        this.subdivisionClass = subdivisionClass;
    }

    /**
     * Returns the corresponding {@link CountryCode}.
     *
     * @return the country code.
     */
    public CountryCode getCountryCode() {
        return countryCode;
    }

    /**
     * Returns an array of subdivisions for this country.
     *
     * @return an array of subdivisions.
     */
    public Subdivision[] getSubdivisions() {
        return subdivisionClass.getEnumConstants();
    }

    /**
     * Gets a {@code SubdivisionCode} by its {@link CountryCode}.
     *
     * @param code the country code to look up.
     * @return the corresponding {@code SubdivisionCode}, or {@code null} if not found.
     */
    public static SubdivisionCode getByCountryCode(CountryCode code) {
        return Arrays.stream(values())
                .filter(sc -> sc.countryCode == code)
                .findFirst()
                .orElse(null);
    }
}
