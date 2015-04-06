(defn- square [x]
        (* x x))

(defn- sum-of-squares [a b]
        (+ (square a) (square b)))

(defn sum-of-squares-of-largest-2 [a b c]
  (apply sum-of-squares (take 2 (sort > [a b c]))))
