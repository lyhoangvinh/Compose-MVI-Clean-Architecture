# The libraries in this template ship their own consumer rules. Moshi adapters are
# generated with KSP, Room DAOs are generated at compile time, and Hilt generated
# code is retained by Hilt's consumer rules, so no broad keep rules are required.
#
# If a future API model intentionally uses Moshi reflection (rather than
# @JsonClass(generateAdapter = true)), add a narrowly scoped @Keep annotation to
# that model instead of a package-wide keep rule.
