(ns sicp-clojure.examples.1-10)

(defn a [x y]
  (cond (= y 0) 0
        (= x 0) (* 2 y)
        (= y 1) 2
        :else (a (- x 1)
                 (a x (- y 1)))))
