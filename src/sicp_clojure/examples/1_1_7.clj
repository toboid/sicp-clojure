;; Newton's method for approximating square roots
;; To find the square root of x, make a guess y.
;; Test if the guess is close enough (to a given tolerance).
;; If the guess is not close enough, use the following formula to
;; calculate an improved guess and iterate until a satisfactory answer is obtained.
;; next-guess =   x/y + y
;;              -----------
;;                   2

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