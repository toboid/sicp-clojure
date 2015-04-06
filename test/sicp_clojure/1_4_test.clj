(ns sicp-clojure.1-4-test
  (:require [clojure.test :refer :all]))

(defn- a-plus-abs-b [a b]
  ((if (> b 0) + -) a b))

(deftest ex_1.4
  (testing "b is positive"
    (is (= (a-plus-abs-b 1 2) 3)))
  (testing "b is negative"
    (is (= (a-plus-abs-b 1 -2) 3)))
  (testing "b is 0"
    (is (= (a-plus-abs-b 1 0) 1))))

