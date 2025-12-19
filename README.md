# ISO-3166-2 Subdivision Library

A Java library that implements the [ISO-3166-2](https://en.wikipedia.org/wiki/ISO_3166-2) subdivision codes ([ISO official page](https://www.iso.org/iso-3166-country-codes.html#2012_iso3166-2)), inspired by and integrated with the `nv-i18n` library.

## Usage

### Direct access to subdivisions

You can access subdivision constants directly from the `SubdivisionCode` class.

```java
import dev.marcosalmeida.i18n.SubdivisionCode;

// Access a specific US subdivision
Subdivision alabama = SubdivisionCode.US.AL;
System.out.println(alabama.getCode());     // "US-AL"

// Access a specific Brazil subdivision
Subdivision saoPaulo = SubdivisionCode.BR.SP;
System.out.println(saoPaulo.getCode());       // "BR-SP"
System.out.println(saoPaulo.getName());       // "São Paulo"

// Access a specific Mexico subdivision
Subdivision mexicoCity = SubdivisionCode.MX.CMX;
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
Subdivision[] subdivisions = SubdivisionCode.getSubdivisions(CountryCode.US);
if (subdivisions != null) {
    for (Subdivision s : subdivisions) {
        System.out.println(s.getCode() + ": " + s.getName());
    }
}
```

### Looking up by ISO-3166-2 code

You can look up subdivisions using their full ISO-3166-2 code (e.g., "US-AL").

```java
import dev.marcosalmeida.i18n.SubdivisionCode;
import dev.marcosalmeida.i18n.Subdivision;

// Look up across all countries
Subdivision al = SubdivisionCode.fromCode("US-AL");

// Look up within a specific country
Subdivision sp = SubdivisionCode.BR.fromCode("BR-SP");
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

- **Public Access**: Uses nested enums to provide direct access to subdivision constants while keeping them grouped by country.
- **`nv-i18n` Integration**: Easily find subdivisions using established `CountryCode` constants.
- **Shortened Keys**: Enum constants use the subdivision part of the code (e.g., `PR`) for a cleaner API.

## Deployment

Artifacts are signed with GPG as required by Sonatype Central. To deploy, use:

```bash
mvn deploy -P deployment
```

Ensure your GPG key is configured correctly in your environment.
