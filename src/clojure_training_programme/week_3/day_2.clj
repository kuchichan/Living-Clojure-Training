(ns clojure-training-programme.core)

; Rotate a sequence
(defn rotate [x xs]
  (let [len (count xs)]
    (take len (nthrest (cycle xs) (mod x len)))))

(= (rotate 2 [1 2 3 4 5]) '(3 4 5 1 2))
(= (rotate -2 [1 2 3 4 5]) '(4 5 1 2 3))
(= (rotate 1 '(:a :b :c)) '(:b :c :a))
(= (rotate -4 '(:a :b :c)) '(:c :a :b))

; Flipping out
(defn flip [fun]
  (fn [a b] (fun b a )))

(= 3 ((flip nth) 2 [1 2 3 4 5]))
(= true ((flip >) 7 8 ))
(= 4 ((flip quot) 2 8))
(= [1 2 3] ((flip take) [1 2 3 4 5] 3))
