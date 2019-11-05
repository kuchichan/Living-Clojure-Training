(ns clojure-training-programme.core)

; Compress a sequence
(= (apply str (#(map first (partition-by identity %)) "Leeeeeeeeerrrrroooyyyy")) "Leroy")
(= (#(map first (partition-by identity %)) [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))
(= (#(map first (partition-by identity %)) [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))

; Pack a sequence

(= (#(partition-by identity %) [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))
(= (#(partition-by identity %) [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))
(= (#(partition-by identity %) [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))

; Drop every nth 
(= ((fn [xs n] (keep-indexed #(if (not= 0 (mod (inc %1) n)) %2 ) xs)) [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
(= ((fn [xs n] (keep-indexed #(if (not= 0 (mod (inc %1) n)) %2 ) xs)) [:a :b :c :d :e :f] 2) [:a :c :e])
(= ((fn [xs n] (keep-indexed #(if (not= 0 (mod (inc %1) n)) %2 ) xs)) [1 2 3 4 5 6] 4) [1 2 3 5 6])

; Iterate 

(= '(1 4 7 10 13) (take 5 (iterate #(+ 3 %) 1)))

; Replicate a Seq

((fn [xs n] (apply concat (map #(repeat n %) xs))) [1 2 3] 2)
(= ((fn [xs n] (mapcat #(repeat n %) xs)) [1 2 3] 2) '(1 1 2 2 3 3))
(= ((fn [xs n] (mapcat #(repeat n %) xs)) [:a :b] 4) '(:a :a :a :a :b :b :b :b))
(= ((fn [xs n] (mapcat #(repeat n %) xs)) [4 5 6] 1) '(4 5 6))
(= ((fn [xs n] (mapcat #(repeat n %) xs)) [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))
(= ((fn [xs n] (mapcat #(repeat n %) xs)) [44 33] 2) '(44 44 33 33))



