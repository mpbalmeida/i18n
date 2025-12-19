#!/bin/bash

# Get the commit message from the file passed as the first argument
commit_msg=$(cat "$1")

# Regex for conventional commits
# Pattern: <type>(<scope>): <description>
# Types: feat, fix, docs, style, refactor, perf, test, build, ci, chore, revert
conventional_re="^(feat|fix|docs|style|refactor|perf|test|build|ci|chore|revert)(\(.+\))?!?: .+$"

if [[ ! $commit_msg =~ $conventional_re ]]; then
    echo "ERROR: Invalid commit message format."
    echo "Commit message must follow the Conventional Commits specification:"
    echo "<type>(<scope>): <description>"
    echo "Example: feat(US): add Florida subdivision"
    echo "Allowed types: feat, fix, docs, style, refactor, perf, test, build, ci, chore, revert"
    exit 1
fi
