# Project Guidelines

This document outlines the rules and conventions for the ISO-3166-2 Subdivision Library.

## 1. `SubdivisionCode` Class
- Acts as the entry point for all subdivisions.
- Country-specific subdivisions are implemented as public nested enums (e.g., `SubdivisionCode.US`).
- Nested enums MUST be named using the 2-letter ISO country code (BR, MX, US, etc.) and sorted alphabetically in the file.
- Provides `getSubdivisions(CountryCode)` and `fromCode(String)` utility methods.

## 2. Country-Specific Subdivision Enums
- MUST be public nested enums inside `SubdivisionCode` to ensure external accessibility of constants.
- MUST implement the `Subdivision` interface.
- Constants MUST use the shortened key from the ISO-3166-2 code (e.g., `AL` for `US-AL`).
- Javadoc documentation is required for each constant.
- MUST provide a static `fromCode(String)` method.

## 3. `Subdivision` Interface
- Provides a polymorphic way to access subdivision data:
    - `getCode()`: Full ISO-3166-2 code (e.g., "US-AL").
    - `getName()`: Local/English name.
    - `getCategory()`: Subdivision category (e.g., "State", "Province").

## 4. Documentation
- All public classes, interfaces, enums, and methods MUST have clear Javadoc.
- The `README.md` should be updated when new countries are added.

## 5. Testing
- Each new country implementation MUST have its own test file (e.g., `SubdivisionUSTest.java`).
- Tests should verify both direct access to constants and access via `SubdivisionCode`.
- General `SubdivisionCode` functionality should be tested in `SubdivisionCodeTest.java`.

## 6. Commit Messages
- This project enforces the [Conventional Commits](https://www.conventionalcommits.org/) specification.
- A git hook is automatically installed via Maven (`git-build-hook-maven-plugin`) to validate commit messages.
- Format: `<type>(<scope>): <description>`
- Example: `feat(US): add Florida subdivision`
- Allowed types: `feat`, `fix`, `docs`, `style`, `refactor`, `perf`, `test`, `build`, `ci`, `chore`, `revert`.

## 7. GPG Signing
- All artifacts MUST be signed with GPG for deployment to Sonatype Central.
- The `maven-gpg-plugin` is configured in the `deployment` profile.
- Signatures are generated during the `verify` phase.
