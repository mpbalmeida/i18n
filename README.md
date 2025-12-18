# ISO-3166-2 Subdivision Library

A Java library that implements the [ISO-3166-2](https://en.wikipedia.org/wiki/ISO_3166-2) subdivision codes ([ISO official page](https://www.iso.org/iso-3166-country-codes.html#2012_iso3166-2)), inspired by and integrated with the `nv-i18n` library.

## Usage

### Direct access to subdivisions

You can access subdivision constants directly from the country-specific enum classes (e.g., `SubdivisionUS`, `SubdivisionBR`).

```java
import dev.marcosalmeida.i18n.SubdivisionUS;
import dev.marcosalmeida.i18n.SubdivisionBR;
import dev.marcosalmeida.i18n.SubdivisionMX;

// Access a specific US subdivision
SubdivisionUS puertoRico = SubdivisionUS.PR;
System.out.println(puertoRico.getCode());     // "US-PR"

// Access a specific Brazil subdivision
SubdivisionBR saoPaulo = SubdivisionBR.SP;
System.out.println(saoPaulo.getCode());       // "BR-SP"
System.out.println(saoPaulo.getName());       // "São Paulo"

// Access a specific Mexico subdivision
SubdivisionMX mexicoCity = SubdivisionMX.CMX;
System.out.println(mexicoCity.getCode());     // "MX-CMX"
System.out.println(mexicoCity.getName());     // "Ciudad de México"
```

### Accessing via CountryCode

The library integrates with `com.neovisionaries.i18n.CountryCode`.

```java
import com.neovisionaries.i18n.CountryCode;
import dev.marcosalmeida.i18n.SubdivisionCode;
import dev.marcosalmeida.i18n.Subdivision;

// Get all subdivisions for a country
SubdivisionCode usCode = SubdivisionCode.getByCountryCode(CountryCode.US);
if (usCode != null) {
    Subdivision[] subdivisions = usCode.getSubdivisions();
    for (Subdivision s : subdivisions) {
        System.out.println(s.getCode() + ": " + s.getName());
    }
}
```

### Core Interface

All subdivision enums implement the `Subdivision` interface:

```java
public interface Subdivision {
    String getCode();     // Returns the full ISO-3166-2 code (e.g., "US-AL")
    String getName();     // Returns the English name
    String getCategory(); // Returns the category (e.g., "State", "District")
}
```

## Features

- **Encapsulated Design**: Uses an interface to provide polymorphic access while keeping specific country enums separate.
- **`nv-i18n` Integration**: Easily find subdivisions using established `CountryCode` constants.
- **Shortened Keys**: Enum constants use the subdivision part of the code (e.g., `PR`) for a cleaner API.
