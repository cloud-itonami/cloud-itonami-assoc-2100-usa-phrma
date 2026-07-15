(ns association.facts-test
  (:require [clojure.test :refer [deftest is]]
            [association.facts :as facts]))

(deftest phrma-has-spec-basis
  (let [sb (facts/spec-basis "phrma")]
    (is (= 2 (count sb)))
    (is (every? #(= "2100" (:association-rule/isic %)) sb))
    (is (every? #(= "USA" (:association-rule/country %)) sb))))

(deftest unknown-association-has-no-spec-basis
  (is (nil? (facts/spec-basis "efpia")))
  (is (nil? (facts/spec-basis "zzz"))))

(deftest coverage-is-honest
  (let [c (facts/coverage ["phrma" "efpia"])]
    (is (= 2 (:requested c)))
    (is (= 1 (:covered c)))
    (is (= ["efpia"] (:missing-associations c)))))

(deftest by-topic-filters
  (is (= ["phrma.guiding-principles-dtc-advertising"]
         (mapv :association-rule/id (facts/by-topic "phrma" :advertising))))
  (is (empty? (facts/by-topic "phrma" :labor)))
  (is (empty? (facts/by-topic "efpia" :ethics))))
