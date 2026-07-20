# ADR 0001: Kotoba is the PhRMA catalog source authority

- Status: Accepted
- Date: 2026-07-21

## Decision

`src/association_facts.kotoba` is the sole production source. Both citations
retain every scalar field, including the deliberately year-only 2018 revision
date. Topic count plus indexed access preserves both distinct two-topic sets.
Unknown values and indexes return zero or typed option-none; no effects are
declared. DataScript EDN is derived provider data.

CI executes reference semantics, restricted JavaScript, instantiated typed
WebAssembly, and production source-authority checks. Clojure and the JVM are
compiler/test hosts only.

## Consequences

- Source date precision is preserved instead of inventing month/day values.
- Multi-topic entries remain complete without host sets.
