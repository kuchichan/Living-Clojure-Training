(ns clojure-training-programme.core)

(fn [n] (fn [x] (reduce * (repeat n x))))
(= 256 (((fn [n] (fn [x] (reduce * (repeat n x)))) 2) 16) (((fn [n] (fn [x] (reduce * (repeat n x)))) 8) 2))
(= [1 8 27 64] (map ((fn [n] (fn [x] (reduce * (repeat n x)))) 3) [1 2 3 4]))
(= [1 2 4 8 16] (map #(((fn [n] (fn [x] (reduce * (repeat n x)))) %) 2) [0 1 2 3 4]))

