(ns clojure-training-programme.core)
;rest
(= [20 30 40] (rest [10 20 30 40]))

; intro to functions
; different ways to create a functions:

(= 8 ((fn add-five [x] (+ x 5)) 3))
(= 8 ((fn [x] (+ x 5)) 3))
(= 8 (#(+ % 5 ) 3))
(= 8 ((partial + 5) 3))

(defn add-five [x]
  (+ x 5))
(= 8 (add-five 3))

; double down
(= (#(* % 2) 2) 4)
(= ((fn double-down [x] (* x 2)) 3) 6)
(= ((fn [x] (* x 2)) 11) 22)
(= ((partial * 2) 7) 14)

;hello world
(= ((fn hello [phrase] (str "Hello, " phrase "!")) "Dave") "Hello, Dave!")
(defn hello-world [x]
  (str "Hello, " x "!"))
(hello-world "Jenn?")

;map
(= '(6 7 8) (map #(+ % 5) '(1 2 3)))

;filter

(= '(6 7) (filter #(> % 5) '(3 4 5 6 7)))

; local bindings
(= 7 (let [x 5] (+ 2 x)))
(= 7 (let [x 3 y 10] (- y x)))
(= 7 (let [x 21] (let [y 3] (/ x y))))

; let it be

(= 10 (let [x 7 y 3 z 1] (+ x y )))
(= 4 (let [x 7 y 3 z 1] (+ z y )))
(= 1 (let [x 7 y 3 z 1] (+ z )))

