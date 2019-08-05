(ns clojure-training-programme.core)

; Pascal Triangle

(defn pascal-triangle [n]
  (loop [x n
         result [1]]
    (if (> x 1)
    (recur (dec x) (conj (into [] (conj (map #(apply + %) (map vector result (rest result))) 1 )) 1))
    result)))

(= (pascal-triangle 1) [1])
(= (map pascal-triangle (range 1 6))
   [      [1]
         [1 1]
        [1 2 1]
       [1 3 3 1]
      [1 4 6 4 1]])

(= (pascal-triangle 11)
   [1 10 45 120 210 252 210 120 45 10 1])
