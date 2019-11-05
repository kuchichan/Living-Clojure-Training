(ns clojure-training-programme.core)

; Advanced destructuring

(= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] [1 2 3 4 5]] [a b c d]))

; A half truth

(= false ((fn half-truth [x & xs] (not (every? #(= % x) xs))) false false))
(= true ((fn half-truth [x & xs] (not (every? #(= % x) xs))) true false))
(= false ((fn half-truth [x & xs] (not (every? #(= % x) xs))) true))
(= true ((fn half-truth [x & xs] (not (every? #(= % x) xs))) false true false))
(= false ((fn half-truth [x & xs] (not (every? #(= % x) xs))) true true true))
(= true ((fn half-truth [x & xs] (not (every? #(= % x) xs))) true true true false))

; GCD

(= ((fn [x y] (if (zero? y) x (recur y (mod x y)))) 2 4) 2) 
(= ((fn [x y] (if (zero? y) x (recur y (mod x y)))) 10 5) 5) 
(= ((fn [x y] (if (zero? y) x (recur y (mod x y)))) 5 7) 1) 
(= ((fn [x y] (if (zero? y) x (recur y (mod x y)))) 1023 858) 33) 
