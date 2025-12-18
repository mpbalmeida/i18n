package dev.marcosalmeida.i18n;

/**
 * Interface representing an ISO-3166-2 subdivision.
 */
public interface Subdivision {
    /**
     * Returns the full ISO-3166-2 code (e.g., "US-AL").
     *
     * @return the subdivision code.
     */
    String getCode();

    /**
     * Returns the English name of the subdivision.
     *
     * @return the subdivision name.
     */
    String getName();

    /**
     * Returns the category of the subdivision (e.g., "State", "District", "Outlying area").
     *
     * @return the subdivision category.
     */
    String getCategory();
}
