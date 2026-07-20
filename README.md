# cloud-itonami-assoc-2100-usa-phrma

Industry self-regulatory rule catalog for the **Pharmaceutical
Research and Manufacturers of America (PhRMA)** — a 19th
industry-association-level source, and the FIRST aligned to ISIC 2100
(manufacture of pharmaceuticals, medicinal chemical and botanical
products), alongside
[`cloud-itonami-assoc-6419-jpn-zenginkyo`](https://github.com/cloud-itonami/cloud-itonami-assoc-6419-jpn-zenginkyo),
[`cloud-itonami-assoc-6512-jpn-sonpo`](https://github.com/cloud-itonami/cloud-itonami-assoc-6512-jpn-sonpo),
[`cloud-itonami-assoc-6612-jpn-jsda`](https://github.com/cloud-itonami/cloud-itonami-assoc-6612-jpn-jsda),
[`cloud-itonami-assoc-6419-deu-bankenverband`](https://github.com/cloud-itonami/cloud-itonami-assoc-6419-deu-bankenverband),
[`cloud-itonami-assoc-6612-usa-finra`](https://github.com/cloud-itonami/cloud-itonami-assoc-6612-usa-finra),
[`cloud-itonami-assoc-6512-usa-naic`](https://github.com/cloud-itonami/cloud-itonami-assoc-6512-usa-naic),
[`cloud-itonami-assoc-6920-jpn-jicpa`](https://github.com/cloud-itonami/cloud-itonami-assoc-6920-jpn-jicpa),
[`cloud-itonami-assoc-6920-usa-aicpa`](https://github.com/cloud-itonami/cloud-itonami-assoc-6920-usa-aicpa),
[`cloud-itonami-assoc-6419-fra-fbf`](https://github.com/cloud-itonami/cloud-itonami-assoc-6419-fra-fbf),
[`cloud-itonami-assoc-6511-jpn-seiho`](https://github.com/cloud-itonami/cloud-itonami-assoc-6511-jpn-seiho),
[`cloud-itonami-assoc-6910-jpn-nichibenren`](https://github.com/cloud-itonami/cloud-itonami-assoc-6910-jpn-nichibenren),
[`cloud-itonami-assoc-6810-jpn-recaj`](https://github.com/cloud-itonami/cloud-itonami-assoc-6810-jpn-recaj),
[`cloud-itonami-assoc-6411-jpn-boj`](https://github.com/cloud-itonami/cloud-itonami-assoc-6411-jpn-boj),
[`cloud-itonami-assoc-6120-usa-ctia`](https://github.com/cloud-itonami/cloud-itonami-assoc-6120-usa-ctia),
[`cloud-itonami-assoc-5110-usa-a4a`](https://github.com/cloud-itonami/cloud-itonami-assoc-5110-usa-a4a),
[`cloud-itonami-assoc-3510-usa-eei`](https://github.com/cloud-itonami/cloud-itonami-assoc-3510-usa-eei),
[`cloud-itonami-assoc-2910-deu-vda`](https://github.com/cloud-itonami/cloud-itonami-assoc-2910-deu-vda),
and
[`cloud-itonami-assoc-5510-usa-ahla`](https://github.com/cloud-itonami/cloud-itonami-assoc-5510-usa-ahla).
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family (ADR-2607141700,
`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`).

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on PhRMA's behalf.

Coverage is reported through bounded `entry-count`, `association-covered?`,
and `by-topic-*` operations. An unknown association has no spec-basis.

## Data

- `src/association_facts.kotoba` — the sole production source; every field
  and ordered topic is exposed through bounded count/index access.
- `schema/association-rule.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

Both PDFs were verified by directly reading their rendered text: the
**Code on Interactions with Health Care Professionals** (whose own
Preamble states PhRMA's full name verbatim) and the **Guiding
Principles: Direct to Consumer Advertisements about Prescription
Medicines**.

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention). Document text
itself remains PhRMA's; this repo stores only citation metadata
(id/title/url/dates), not full text.

## Verification

Run `clojure -M:test` and `clojure -M:lint`. Qualification covers reference
semantics, restricted JavaScript, and instantiated typed WebAssembly. The JVM
is a compiler/test host only.
