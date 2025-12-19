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

// Access a specific Canada subdivision
Subdivision ontario = SubdivisionCode.CA.ON;
System.out.println(ontario.getCode());        // "CA-ON"
System.out.println(ontario.getName());        // "Ontario"

// Access a specific Ireland subdivision
Subdivision dublin = SubdivisionCode.IE.D;
System.out.println(dublin.getCode());         // "IE-D"
System.out.println(dublin.getName());         // "Dublin"

// Access a specific Italy subdivision
Subdivision lombardy = SubdivisionCode.IT.IT_25;
System.out.println(lombardy.getCode());       // "IT-25"
System.out.println(lombardy.getName());       // "Lombardia"
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

### Looking up subdivisions

You can look up subdivisions by their full ISO-3166-2 code, their subdivision part, or their name.

```java
import dev.marcosalmeida.i18n.SubdivisionCode;
import dev.marcosalmeida.i18n.Subdivision;
import java.util.Optional;

// Look up across all countries by full code
Subdivision al = SubdivisionCode.fromCode("US-AL");

// Look up within a specific country
Subdivision sp = SubdivisionCode.BR.fromCode("BR-SP");

// Look up by subdivision part (e.g., "AL")
Subdivision alShort = SubdivisionCode.US.fromCode("AL");

// Look up by name
Optional<Subdivision> california = SubdivisionCode.US.fromName("California");

// Unified lookup (tries code then name)
Optional<Subdivision> ny = SubdivisionCode.US.find("New York");
Optional<Subdivision> caPart = SubdivisionCode.US.find("CA");
```

### Getting the subdivision code part

You can extract the subdivision part of the ISO-3166-2 code (e.g., "AL" from "US-AL").

```java
Subdivision alabama = SubdivisionCode.US.AL;
System.out.println(alabama.getSubdivisionCode()); // "AL"
```

### Parent-Child Relationships

The library supports hierarchical relationships between subdivisions (e.g., Irish counties belonging to provinces).

```java
import dev.marcosalmeida.i18n.SubdivisionCode;
import dev.marcosalmeida.i18n.Subdivision;
import java.util.Optional;

Subdivision dublin = SubdivisionCode.IE.D;
Optional<Subdivision> parent = dublin.getParent();
if (parent.isPresent()) {
    System.out.println("Parent: " + parent.get().getName()); // "Leinster"
}
```

### Filtering subdivisions

You can filter subdivisions by category or parent.

```java
// Get all provinces in Ireland
Subdivision[] provinces = SubdivisionCode.IE.getProvinces();

// Get all counties in a specific province
Subdivision leinster = SubdivisionCode.IE.L;
Subdivision[] countiesInLeinster = SubdivisionCode.IE.getByParent(leinster);

// Global filtering across all countries
Subdivision[] allStates = SubdivisionCode.getStates();
```

### Core Interface

All subdivision enums implement the `Subdivision` interface:

```java
public interface Subdivision {
    String getCode();            // Returns the full ISO-3166-2 code (e.g., "US-AL")
    String getSubdivisionCode(); // Returns the subdivision part (e.g., "AL")
    String getName();            // Returns the local/English name
    String getCategory();        // Returns the category (e.g., "State", "District")
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
