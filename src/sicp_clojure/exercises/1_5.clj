;; Exercise 1.5.  Ben Bitdiddle has invented a test to determine whether the interpreter he is faced with is using
;; applicative-order evaluation or normal-order evaluation. He defines the following two procedures:
;;
;;(defn p [] (p))
;;
;;(defn evaluation-order-test [x y]
;;  (if (= x 0)
;;    0
;;    y))
;;
;; Then he evaluates the expression
;;
;; (evaluation-order-test 0 (p))
;;
;; What behavior will Ben observe with an interpreter that uses applicative-order evaluation?
;; What behavior will he observe with an interpreter that uses normal-order evaluation?
;; Explain your answer. (Assume that the evaluation rule for the special form if is the same whether the interpreter
;; is using normal or applicative order: The predicate expression is evaluated first,
;; and the result determines whether to evaluate the consequent or the alternative expression.)

(ns sicp-clojure.exercises.1-5
  (:require [clojure.test :refer :all]))

(defn p [] (p))

(defn evaluation-order-test [x y]
  (if (= x 0)
    0
    y))

;; Applicative order evaluation
;; In applicative order evaluation operands in a combination are evaluated before the operators,
;; so (p) will be evaluated before (evaluation-order-test).
;; In scheme this test would not return because it is an infinately recursive process.
;; In Clojure, it blows the stack because tail calls are not optimised (need to use recur to get a similar effect).

(deftest ex_1.5
  (testing "applicative order evaluation blows stack due to infinite recursion"
    (is (thrown? StackOverflowError (evaluation-order-test 0 (p))))))

;; Normal order evaluation
;; Would return 0.
;; Operands are evaluated when they are needed.
;; If is a special form that only evaluates its alternative expression if it's predicate expression evaluates to false.
;; In this case the predicate will evaluate to true and so the alternative expression is never
;; evaluated and the infinitely recursive procedure p is never evaluated.