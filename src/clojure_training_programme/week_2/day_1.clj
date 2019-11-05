(ns clojure-training-programme.core)

; fibonacci
(defn fibo [x]
  (cond
    (= 1 x) '(1)
    (= 2 x) '(1 1)
    (< 2 x) (concat (fibo (- x 1)) [(+ (last (fibo (- x 1))) (last (fibo(- x 2))))]  
                  )))

(defn tail-fibo [n]
  (loop [x n
         result '(1 1)]
    (if (> x 2)
      (recur (dec x) (concat result [(reduce + (take 2 (reverse result)))]))
      result)))

(= (tail-fibo 3) '(1 1 2))
(= (tail-fibo 6) '(1 1 2 3 5 8))
(= (tail-fibo 8) '(1 1 2 3 5 8 13 21))
(tail-fibo 90)

; Get the gaps
(= ((fn upper-filter [phrase] (apply str (filter #(Character/isUpperCase %) phrase))) "HeLlO WoRlD!") "HLOWRD")
(empty? ((fn upper-filter [phrase] (apply str (filter #(Character/isUpperCase %) phrase))) "nothing"))
(= ((fn upper-filter [phrase] (apply str (filter #(Character/isUpperCase %) phrase))) "$#A(*&987Zf") "AZ")

; Intro to some

(= 6 (some #{2 7 6} [5 6 7 8]))
(= 6 (some #(when (even? %) %) [5 6 7 8]))

; Factorial fun

(= ((fn factorial [n] (loop [x n result 1] (if (> x 1) (recur (dec x) (* result x)) result))) 1) 1)
(= ((fn factorial [n] (loop [x n result 1] (if (> x 1) (recur (dec x) (* result x)) result))) 3) 6)
(= ((fn factorial [n] (loop [x n result 1] (if (> x 1) (recur (dec x) (* result x)) result))) 5) 120)
(= ((fn factorial [n] (loop [x n result 1] (if (> x 1) (recur (dec x) (* result x)) result))) 8) 40320)

; Intro to destructuring

(= [2 4] (let [[a b c d e f g] (range)] [c e]))


