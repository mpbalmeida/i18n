package dev.marcosalmeida.i18n;

import com.neovisionaries.i18n.CountryCode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubdivisionTest {

    @Test
    public void testUSSubdivisions() {
        // Direct access to the enum constant
        SubdivisionUS al = SubdivisionUS.AL;
        assertEquals("US-AL", al.getCode());
        assertEquals("Alabama", al.getName());

        Subdivision[] subdivisions = SubdivisionCode.US.getSubdivisions();
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
    public void testGetByCountryCode() {
        SubdivisionCode us = SubdivisionCode.getByCountryCode(CountryCode.US);
        assertNotNull(us);
        assertEquals(SubdivisionCode.US, us);

        SubdivisionCode br = SubdivisionCode.getByCountryCode(CountryCode.BR);
        assertNotNull(br);
        assertEquals(SubdivisionCode.BR, br);
    }

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
