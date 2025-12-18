package dev.marcosalmeida.i18n;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubdivisionMXTest {

    @Test
    public void testMXSubdivisions() {
        SubdivisionMX agu = SubdivisionMX.AGU;
        assertEquals("MX-AGU", agu.getCode());
        assertEquals("Aguascalientes", agu.getName());
        assertEquals("state", agu.getCategory());

        Subdivision[] subdivisions = SubdivisionCode.MX.getSubdivisions();
        assertNotNull(subdivisions);
        assertEquals(32, subdivisions.length); // 31 states + 1 federal entity

        Subdivision aguascalientes = subdivisions[0];
        assertEquals("MX-AGU", aguascalientes.getCode());
        assertEquals("Aguascalientes", aguascalientes.getName());

        Subdivision zacatecas = subdivisions[31];
        assertEquals("MX-ZAC", zacatecas.getCode());
        assertEquals("Zacatecas", zacatecas.getName());
        assertEquals("state", zacatecas.getCategory());

        Subdivision cmx = SubdivisionMX.CMX;
        assertEquals("MX-CMX", cmx.getCode());
        assertEquals("Ciudad de México", cmx.getName());
        assertEquals("federal entity", cmx.getCategory());
    }
}
