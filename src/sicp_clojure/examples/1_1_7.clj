(ns sicp-clojure.examples.1-1-7
  (:require [sicp-clojure.examples.1-1-4 :refer :all]))

(defn good-enough? [guess x]
  (< (Math/abs (- (square guess) x)) 0.001))

(defn average [x y]
  (/ (+ x y) 2))

(defn improve [guess x]
  (average guess (/ x guess)))

(defn sqrt-iter [guess x]
  (if (good-enough? guess x)
    guess
    (sqrt-iter (improve guess x) x)))

(defn sqrt [x]
  (sqrt-iter 1.0 x))