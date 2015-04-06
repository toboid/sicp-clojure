;; Exercise 1.3.
;; Define a procedure that takes three numbers as arguments and returns the sum of the squares of the two larger numbers.

(ns sicp-clojure.exercises.1-3
  (:require [clojure.test :refer :all]))

(defn- square [x]
  (* x x))

(defn- sum-of-squares [a b]
  (+ (square a) (square b)))

(defn sum-of-squares-of-largest-2 [a b c]
  (apply sum-of-squares (take 2 (sort > [a b c]))))

(deftest ex-1.3
  (is (= 13 (sum-of-squares-of-largest-2 1 3 2))))
