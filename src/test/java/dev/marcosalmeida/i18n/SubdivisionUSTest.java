package dev.marcosalmeida.i18n;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubdivisionUSTest {

    @Test
    public void testUSSubdivisions() {
        // Direct access to the enum constant
        SubdivisionCode.US al = SubdivisionCode.US.AL;
        assertEquals("US-AL", al.getCode());
        assertEquals("Alabama", al.getName());

        Subdivision[] subdivisions = SubdivisionCode.getSubdivisions(com.neovisionaries.i18n.CountryCode.US);
        assertNotNull(subdivisions);
        assertEquals(57, subdivisions.length); // 50 states + DC + 6 outlying areas

        Subdivision alabama = subdivisions[0];
        assertEquals("US-AL", alabama.getCode());
        assertEquals("Alabama", alabama.getName());
        assertEquals("State", alabama.getCategory());

        Subdivision virginIslands = subdivisions[56];
        assertEquals("US-VI", virginIslands.getCode());
        assertEquals("Virgin Islands, U.S.", virginIslands.getName());
        assertEquals("Outlying area", virginIslands.getCategory());
    }

    @Test
    public void testFromCode() {
        SubdivisionCode.US pr = SubdivisionCode.US.fromCode("US-PR");
        assertEquals(SubdivisionCode.US.PR, pr);

        assertThrows(IllegalArgumentException.class, () -> SubdivisionCode.US.fromCode("INVALID"));
    }
}
