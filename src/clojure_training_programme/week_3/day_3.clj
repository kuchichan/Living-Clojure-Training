(ns clojure-training-programme.core)

                                        ; inverse reverse
(defn inverse-interleave [col i]
  (partition
   (/ (count col) i)
   (apply interleave
          (partition i col)))
  )

(= (inverse-interleave [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))
(= (inverse-interleave (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))
(= (inverse-interleave (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))

                                        ; split by type

(defn split-by-type [col]
  (vals (group-by type col))
  )

( = (set (split-by-type [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})
( = (set (split-by-type [:a "foo" "bar" :b])) #{[:a :b] ["foo" "bar"]})
( = (set (split-by-type [[1 2] :a  [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})
