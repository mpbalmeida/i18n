package dev.marcosalmeida.i18n;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubdivisionBRTest {

    @Test
    public void testBRSubdivisions() {
        SubdivisionCode.BR ac = SubdivisionCode.BR.AC;
        assertEquals("BR-AC", ac.getCode());
        assertEquals("Acre", ac.getName());
        assertEquals("state", ac.getCategory());

        Subdivision[] subdivisions = SubdivisionCode.getSubdivisions(com.neovisionaries.i18n.CountryCode.BR);
        assertNotNull(subdivisions);
        assertEquals(27, subdivisions.length); // 26 states + 1 federal district

        Subdivision acre = subdivisions[0];
        assertEquals("BR-AC", acre.getCode());
        assertEquals("Acre", acre.getName());

        Subdivision tocantins = subdivisions[26];
        assertEquals("BR-TO", tocantins.getCode());
        assertEquals("Tocantins", tocantins.getName());
        assertEquals("state", tocantins.getCategory());

        Subdivision df = SubdivisionCode.BR.DF;
        assertEquals("BR-DF", df.getCode());
        assertEquals("Distrito Federal", df.getName());
        assertEquals("federal district", df.getCategory());
    }

    @Test
    public void testFromCode() {
        SubdivisionCode.BR ac = SubdivisionCode.BR.fromCode("BR-AC");
        assertEquals(SubdivisionCode.BR.AC, ac);

        assertThrows(IllegalArgumentException.class, () -> SubdivisionCode.BR.fromCode("INVALID"));
    }
}
