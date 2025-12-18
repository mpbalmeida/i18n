# Project Guidelines

This document outlines the rules and conventions for the ISO-3166-2 Subdivision Library.

## 1. `SubdivisionCode` Enum
- All constants in `SubdivisionCode` MUST be sorted alphabetically by their name.
- Each constant must be linked to its corresponding `com.neovisionaries.i18n.CountryCode`.
- Each constant must be linked to its country-specific implementation class (e.g., `SubdivisionUS.class`).

## 2. Country-Specific Subdivision Enums
- Enums MUST implement the `Subdivision` interface.
- Constants MUST use the shortened key from the ISO-3166-2 code (e.g., `AL` for `US-AL`).
- Enums MUST be public to allow direct access to constants.
- Javadoc documentation is required for each constant.

## 3. `Subdivision` Interface
- Provides a polymorphic way to access subdivision data:
    - `getCode()`: Full ISO-3166-2 code (e.g., "US-AL").
    - `getName()`: Local/English name.
    - `getCategory()`: Subdivision category (e.g., "State", "Province").

## 4. Documentation
- All public classes, interfaces, enums, and methods MUST have clear Javadoc.
- The `README.md` should be updated when new countries are added.

## 5. Testing
- Each new country implementation MUST have corresponding tests in `SubdivisionTest.java`.
- Tests should verify both direct access and access via `SubdivisionCode`.
