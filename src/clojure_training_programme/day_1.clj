(ns  clojure-training-programme.core)

; Problem #1
(= "HELLO WORLD" (.toUpperCase "hello world"))

; Problem #2
(= (list :a :b :c '(:a :b :c)))

; Problem #3
(= '(1 2 3 4) (conj '(3 4) 2 1))

; Problem #4
(= [:a :b :c] 
   (list :a :b :c) 
   (vec '(:a :b :c))
   (vector :a :b :c))

; Problem #5
(= [1 2 3 4] (conj [1 2 3] 4))
(= [1 2 3 4] (conj [1 2] 3 4))

; Problem #6
(= #{:a :b :c :d} (set '(:a :a :b :b :c :c :d :d)))
(= #{:a :b :c :d} (clojure.set/union #{:a :b :c} #{:b :c :d}))

; Problem #7
(= #{1 2 3 4} (conj #{1 4 3} 2))

; Problem #8 
( = (:b {:a 10 :b 20 :c 30}) ((hash-map :a 10 :b 20 :c 30) :b))
( = (:b {:a 10 :b 20 :c 30}) (:b { :a 10 :b 20 :c 30 }))

; Problem #9
(= {:a 1 :b 2 :c 3} (conj {:a 1} [:b 2] [:c 3]))

; Problem #10

(= 3 (first '(3 2 1)))
(= 3 (second [2 3 4]))
(= 3 (last (list 1 2 3)))
