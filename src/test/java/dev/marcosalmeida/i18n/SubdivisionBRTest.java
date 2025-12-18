package dev.marcosalmeida.i18n;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubdivisionBRTest {

    @Test
    public void testBRSubdivisions() {
        SubdivisionBR ac = SubdivisionBR.AC;
        assertEquals("BR-AC", ac.getCode());
        assertEquals("Acre", ac.getName());
        assertEquals("state", ac.getCategory());

        Subdivision[] subdivisions = SubdivisionCode.BR.getSubdivisions();
        assertNotNull(subdivisions);
        assertEquals(27, subdivisions.length); // 26 states + 1 federal district

        Subdivision acre = subdivisions[0];
        assertEquals("BR-AC", acre.getCode());
        assertEquals("Acre", acre.getName());

        Subdivision tocantins = subdivisions[26];
        assertEquals("BR-TO", tocantins.getCode());
        assertEquals("Tocantins", tocantins.getName());
        assertEquals("state", tocantins.getCategory());

        Subdivision df = SubdivisionBR.DF;
        assertEquals("BR-DF", df.getCode());
        assertEquals("Distrito Federal", df.getName());
        assertEquals("federal district", df.getCategory());
    }
}
