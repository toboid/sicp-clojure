(ns sicp-clojure.examples.1-1-6)

(defn abs [x]
  (cond (> x 0) x
        (= x 0) 0
        (< x 0) (- x)))
