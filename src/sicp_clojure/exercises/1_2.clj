;; Exercise 1.2.
;; Translate the following expression into prefix form
;; 5 + 4 + (2 - (3 - (6 + 4/5)))
;; -----------------------------
;;        3(6 - 2)(2 - 7)

(ns sicp-clojure.exercises.1-2
  (:require [clojure.test :refer :all]))

(deftest ex_1.2
  (is (= -37/150 (/
                   (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5)))))
                   (* 3 (- 6 2) (- 2 7))))))
