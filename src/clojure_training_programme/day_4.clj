(ns clojure-training-programme.core)

; Penultimate element
(= (#(second(reverse % )) (list 1 2 3 4 5)) 4)
(= (#(second(reverse % ))  ["a" "b" "c"]) "b")
(= (#(second(reverse % )) [[1 2] [3 4]]) [1 2])

(defn pen [xs] 
     (if (empty? (rest (rest xs))) 
       (first xs) 
       (pen (next xs)))) 
; Sum it all up

(= (reduce + [1 2 3]) 6)
(= (reduce + (list 0 -2 5 5)) 8)
(= (reduce + #{4 2 1}) 7)
(= (reduce + '(0 0 -1)) -1)
(= (reduce + '(1 10 3)) 14)

(= (filter odd? #{1 2 3 4 5}) '(1 3 5))
(= (filter odd? [4 2 1 6]) '(1))
(= (filter odd? [2 2 4 6]) '())
(= (filter odd? [1 1 1 3]) '(1 1 1 3))

; Palindrome detector
(defn palindrome [x]
  (if (= java.lang.String (type x))
    (= (apply str (reverse x)))
    (= (reverse x) x)))

(false? (palindrome '(1 2 3 4 5)))
(true? (palindrome "racecar"))
(true? (palindrome [:foo :bar :foo]))
(true? (palindrome '(1 1 3 3 1 1)))
(false? (palindrome '(:a :b :c)))

; Duplicate sequence

(= ((fn du [xs] (reduce concat (map vector xs xs))) [1 2 3]) '(1 1 2 2 3 3))
(= ((fn du [xs] (reduce concat (map vector xs xs))) [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))
(= ((fn du [xs] (reduce concat (map vector xs xs))) [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))

