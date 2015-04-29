;; Exercise 1.7:
;; The good-enough? test used in computing square
;; roots will not be very effective for finding the square roots of very
;; small numbers. Also, in real computers, arithmetic operations are
;; almost always performed with limited precision. This makes our
;; test inadequate for very large numbers. Explain these statements,
;; with examples showing how the test fails for small and large numbers.
;; An alternative strategy for implementing good-enough? is to
;; watch how guess changes from one iteration to the next and to
;; stop when the change is a very small fraction of the guess. Design
;; a square-root procedure that uses this kind of end test. Does this
;; work better for small and large numbers?

;; For very small numbers the tolerance used of the good-enough? procedure will
;; be a large proportion of the number that we are finding the square root for.
;; This means that the procedure will be comparatively inaccurate.
;; For very large numbers, precision will be reduced resulting in the algorithm not
;; finding a guess which is within the required tolerance.
;; In scheme the procedure would never complete, it causes a stack overflow since
;; Clojure does not have tail recursion.

(ns sicp-clojure.exercises.1-7
  (:require [clojure.test :refer :all]
            [sicp-clojure.examples.1-1-4 :refer :all]
            [sicp-clojure.examples.1-1-7 :refer :all]))

(defn- nearly-equal? [x y tolerance]
  (< (Math/abs (- x y)) tolerance))

(defn- proportional-good-enough? [guess x]
  (< (Math/abs (- (square guess) x)) (* x 0.00001)))

(defn- proportional-sqrt-iter [guess x]
  (if (proportional-good-enough? guess x)
    guess
    (proportional-sqrt-iter (improve guess x) x)))

(defn- proportional-sqrt [x]
  (proportional-sqrt-iter 1.0 x))

(let [small-number 0.0001
      large-number 10000000000000]

  (deftest fixed-tolerance-square-root
    (testing "does not accurately calcuate square root of small numbers"
      (is (not (nearly-equal?
                 (square (sqrt small-number))
                 small-number
                 0.0001))))
    (testing "blows the stack when calculating the square root of large numbers"
      (is (thrown? StackOverflowError (sqrt large-number)))))

  (deftest proportional-tolerance-square-root
    (testing "calcuates square root of small numbers"
      (is (nearly-equal?
            (square (proportional-sqrt small-number))
            small-number
            0.0001)))
    (testing "calcuates the square root of large numbers"
      (is (nearly-equal?
            (square (proportional-sqrt large-number))
            large-number
            100000)))))