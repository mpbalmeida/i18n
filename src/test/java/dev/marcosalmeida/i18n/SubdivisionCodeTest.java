package dev.marcosalmeida.i18n;

import com.neovisionaries.i18n.CountryCode;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SubdivisionCodeTest {

    @Test
    public void testGetByCountryCode() {
        SubdivisionCode us = SubdivisionCode.getByCountryCode(CountryCode.US);
        assertNotNull(us);
        assertEquals(SubdivisionCode.US, us);

        SubdivisionCode br = SubdivisionCode.getByCountryCode(CountryCode.BR);
        assertNotNull(br);
        assertEquals(SubdivisionCode.BR, br);

        SubdivisionCode mx = SubdivisionCode.getByCountryCode(CountryCode.MX);
        assertNotNull(mx);
        assertEquals(SubdivisionCode.MX, mx);
    }
}
