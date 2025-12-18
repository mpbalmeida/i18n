package dev.marcosalmeida.i18n;

/**
 * ISO-3166-2 subdivisions for Mexico.
 *
 * <p>
 * This includes 31 states and 1 federal entity (Ciudad de México).
 * </p>
 *
 * @see <a href="https://en.wikipedia.org/wiki/ISO_3166-2:MX">ISO 3166-2:MX</a>
 */
public enum SubdivisionMX implements Subdivision {
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

    SubdivisionMX(String code, String name, String category) {
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
