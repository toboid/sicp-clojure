;; Exercise 1.4.
;; Observe that our model of evaluation allows for combinations whose operators are compound expressions.
;; Use this observation to describe the behavior of the following procedure:

(ns sicp-clojure.exercises.1-4
  (:require [clojure.test :refer :all]))

(defn- a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

(deftest ex_1.4
  (testing "uses addition function when b is positive"
    (is (= 3 (a-plus-abs-b 1 2))))
  (testing "uses substraction function when b is negative"
    (is (= 5 (a-plus-abs-b 1 -4))))
  (testing "uses substraction function when b is negative 0"
    (is (= 1 (a-plus-abs-b 1 0)))))

