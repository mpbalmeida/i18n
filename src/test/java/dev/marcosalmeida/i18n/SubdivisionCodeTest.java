package dev.marcosalmeida.i18n;

import com.neovisionaries.i18n.CountryCode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubdivisionCodeTest {

    @Test
    public void testGetSubdivisions() {
        Subdivision[] us = SubdivisionCode.getSubdivisions(CountryCode.US);
        assertNotNull(us);
        assertTrue(us.length > 0);

        Subdivision[] br = SubdivisionCode.getSubdivisions(CountryCode.BR);
        assertNotNull(br);
        assertTrue(br.length > 0);

        Subdivision[] mx = SubdivisionCode.getSubdivisions(CountryCode.MX);
        assertNotNull(mx);
        assertTrue(mx.length > 0);

        assertNull(SubdivisionCode.getSubdivisions(CountryCode.AF));
    }

    @Test
    public void testFromCode() {
        Subdivision al = SubdivisionCode.fromCode("US-AL");
        assertNotNull(al);
        assertEquals("Alabama", al.getName());

        Subdivision sp = SubdivisionCode.fromCode("BR-SP");
        assertNotNull(sp);
        assertEquals("São Paulo", sp.getName());

        assertThrows(IllegalArgumentException.class, () -> SubdivisionCode.fromCode("INVALID"));
        assertThrows(IllegalArgumentException.class, () -> SubdivisionCode.fromCode("US-XX"));
    }
}
