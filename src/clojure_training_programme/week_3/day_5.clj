                                        ; Anagram finder

(defn anagram [col]
  (loop [in col
         out []]
    (if (empty? in)
      (set (filter #(> (count %) 1) out)) ; this could be better...
      (recur (rest in)
             (conj out
                   (set (filter #(= (sort (first in)) (sort %)) col))))
      )))

(= (anagram ["meat" "mat" "team" "mate" "eat"])
   #{#{"meat" "team" "mate"}})
(= (anagram ["veer" "lake" "item" "kale" "mite" "ever"])
 #{#{"veer" "ever"} #{"lake" "kale"} #{"mite" "item"}})


                                        ; Solution of 1067 that is extremely elegant

#(->> (group-by sort %)
      (vals)
      (map set)
      (filter (comp seq rest))
      (set))
