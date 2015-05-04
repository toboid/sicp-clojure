(ns sicp-clojure.exercises.1-8
  (:require [clojure.test :refer :all]))

;; Newton's method for cube roots is based on the fact that if y is an approximation to the cube root of x,
;; then a better approximation is given by the value
;;
;; (x / (y * y)) + 2y
;; ------------------
;;         3

(defn- square [x] (* x x))
(defn- cube [x] (* x x x ))

(defn- good-enough? [guess x]
  (< (Math/abs (- (cube guess) x)) 0.001))

(defn- improve [guess x]
  (/ (+
       (/ x (square guess))
       (* 2 guess))
     3))

(defn- cube-root-iter [guess x]
  (if (good-enough? guess x)
    guess
    (cube-root-iter (improve guess x) x)))

(defn- cube-root [x]
  (cube-root-iter 1.0 x))

(defn- nearly-equal? [x y tolerance]
  (< (Math/abs (- x y)) tolerance))

(deftest cube-root-test
  (testing "calculates cube root of positive number"
    (is (nearly-equal? (cube-root 27) 3 0.001)))
  (testing "calculates cube root of negative number"
    (is (nearly-equal? (cube-root -27) -3 0.001))))