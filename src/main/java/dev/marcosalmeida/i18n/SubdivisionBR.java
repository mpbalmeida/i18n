package dev.marcosalmeida.i18n;

/**
 * ISO-3166-2 subdivisions for Brazil.
 *
 * <p>
 * This includes 26 states and 1 federal district.
 * </p>
 */
public enum SubdivisionBR implements Subdivision {
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

    SubdivisionBR(String code, String name, String category) {
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
