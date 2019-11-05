(ns clojure-training-programme.core)

; Symmetric difference
(= ((fn symm-diff [x y] (clojure.set/union (clojure.set/difference x y) (clojure.set/difference y x))) #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})

(= ((fn symm-diff [x y] (clojure.set/union (clojure.set/difference x y) (clojure.set/difference y x))) #{:a :b :c} #{}) #{:a :b :c})

; lcm

(defn lcm-multi [& args]
  (letfn [(gcd [x y]
              (if (zero? y)
              x
              (recur y (mod x y))))
         (lcm [a b]
              (/ (* a b) (gcd a b)))
         ]
  (reduce lcm args)))
        
(lcm-multi 5 3 7)
