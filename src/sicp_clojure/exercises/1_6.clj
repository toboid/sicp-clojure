;; Exercise 1.6:
;; Alyssa P. Hacker doesn’t see why if needs to be pro-
;; vided as a special form. “Why can’t I just define it as an ordinary
;; procedure in terms of cond ?” she asks. Alyssa’s friend Eva Lu Ator
;; claims this can indeed be done, and she defines a new version of
;; if :
;; (define (new-if predicate then-clause else-clause)
;;         (cond (predicate then-clause)
;;               (else else-clause)))
;; Eva demonstrates the program for Alyssa:
;; (new-if (= 2 3) 0 5)
;; 5
;; (new-if (= 1 1) 0 5)
;; 0
;; Delighted, Alyssa uses new-if to rewrite the square-root program:
;; (define (sqrt-iter guess x)
;;         (new-if (good-enough? guess x)
;;                 guess
;;                 (sqrt-iter (improve guess x) x)))
;; What happens when Alyssa attempts to use this to compute square
;; roots? Explain.

(ns sicp-clojure.exercises.1-6
  (:require [clojure.test :refer :all]
            [sicp-clojure.examples.1-1-7 :refer :all]))

(defn- new-if [predicate then-clause else-clause]
  (cond predicate then-clause
        :else else-clause))

(defn- new-sqrt-iter [guess x]
  (new-if (good-enough? guess x)
          guess
          (new-sqrt-iter (improve guess x) x)))

(defn- new-sqrt [x]
  (new-sqrt-iter 1.0 x))

(deftest new-if-test
  (testing "evaluates consequent expression when predicate is true"
    (is (= 1 (new-if true 1 nil))))
  (testing "evaluates alternative expression when predicate is false"
    (is (= 1 (new-if false nil 1)))))

;; Use of the new-if procedure instead of the if special form causes a stack overflow error
;; (in scheme the procedure would never finish due to tail call optimisation).
;; The if special form only evaluates the alternative expression if the predicate is true.
(deftest ex_1.6
  (testing "new-sqrt blows the stack"
    (is (thrown? StackOverflowError (new-sqrt 2)))))
