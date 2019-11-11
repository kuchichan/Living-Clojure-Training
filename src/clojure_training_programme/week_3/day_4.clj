(ns clojure-training-programme.core)

(defn prime? [n]
  (or (= 2 n)
      (not-any?  #(= 0 (mod n %))
                 (range 3 ( inc (Math/sqrt n)) 2))))

(defn take-prime [n]
  (take n (filter #(prime? %) (cons 2 (iterate (partial + 2) 3)))))

(= (take-prime 2) [2 3])
(= (take-prime 5) [2 3 5 7 11])
(= (last (take-prime 100)) 541)



