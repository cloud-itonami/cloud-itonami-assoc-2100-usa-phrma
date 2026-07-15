(ns association.facts
  "Industry self-regulatory rule catalog for the Pharmaceutical Research
  and Manufacturers of America (PhRMA, Wikidata Q5683113) -- a 19th
  industry-association-level source (see cloud-itonami-assoc-6419-jpn-zenginkyo,
  -6512-jpn-sonpo, -6612-jpn-jsda, -6419-deu-bankenverband, -6612-usa-finra,
  -6512-usa-naic, -6920-jpn-jicpa, -6920-usa-aicpa, -6419-fra-fbf,
  -6511-jpn-seiho, -6910-jpn-nichibenren, -6810-jpn-recaj, -6411-jpn-boj,
  -6120-usa-ctia, -5110-usa-a4a, -3510-usa-eei, -2910-deu-vda,
  -5510-usa-ahla for the first eighteen) per ADR-2607141700
  (cloud-itonami-compliance-fact-federation). The FIRST entry aligned to
  ISIC 2100 (manufacture of pharmaceuticals, medicinal chemical and
  botanical products) -- a new industry code for this family. A rule
  not in this table has NO spec-basis, full stop; extend `catalog`, do
  not invent an id/url.

  Both PDFs were verified by directly reading their rendered text via
  the Read tool: the Code on Interactions with Health Care
  Professionals' own Preamble confirms PhRMA's full name verbatim
  ('The Pharmaceutical Research and Manufacturers of America (PhRMA)
  represents research-based pharmaceutical and biotechnology
  companies...'), though its exact effective date is not on the pages
  read (WebSearch corroborates 2022-01-01 for the most recent
  revision); the Guiding Principles on Direct to Consumer
  Advertisements title page confirms the document itself, with '2018'
  embedded in the verified URL path indicating that revision year.")

(def catalog
  "assoc-slug -> vector of self-regulatory rule entries."
  {"phrma"
   [{:association-rule/id "phrma.code-on-interactions-with-hcps"
     :association-rule/title "Code on Interactions with Health Care Professionals"
     :association-rule/association "phrma"
     :association-rule/isic "2100"
     :association-rule/country "USA"
     :association-rule/kind :self-regulatory-code
     :association-rule/url "https://cdn.aglty.io/phrma/global/resources/PhRMA%20Code%20-%20Final.pdf"
     :association-rule/url-provenance :official-association-site
     :association-rule/last-revised-date "2022-01-01"
     :association-rule/retrieved-at "2026-07-15"
     :association-rule/topic #{:ethics :member-conduct}}
    {:association-rule/id "phrma.guiding-principles-dtc-advertising"
     :association-rule/title "PhRMA Guiding Principles: Direct to Consumer Advertisements about Prescription Medicines"
     :association-rule/association "phrma"
     :association-rule/isic "2100"
     :association-rule/country "USA"
     :association-rule/kind :self-regulatory-code
     :association-rule/url "https://cdn.aglty.io/phrma/global/resources/PhRMA_Guiding_Principles_2018.pdf"
     :association-rule/url-provenance :official-association-site
     :association-rule/last-revised-date "2018"
     :association-rule/retrieved-at "2026-07-15"
     :association-rule/topic #{:advertising :consumer-protection}}]})

(defn spec-basis [assoc-slug] (get catalog assoc-slug))

(defn coverage
  ([] (coverage (keys catalog)))
  ([slugs]
   (let [have (filter catalog slugs)
         missing (remove catalog slugs)]
     {:requested (count slugs)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (str "cloud-itonami-assoc-2100-usa-phrma Wave 0 (ADR-2607141700): "
                 (count (get catalog "phrma")) " phrma entries seeded with an "
                 "official phrma.org citation. Extend "
                 "`association.facts/catalog`, never fabricate a rule id/url.")})))

(defn by-topic [assoc-slug topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis assoc-slug)))
