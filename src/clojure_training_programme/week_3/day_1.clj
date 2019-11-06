(ns clojure-training-programme.core)

(let [[v left right :as tr]
      [:a nil]]
  (v left))

(defn tree? [col]
    (let [[v left right :as tr]
     col]
    (if (or (not (= 3 (count tr))) (sequential? v))
      false
      (cond 
        (and (nil? left) (nil? right)) true
        (and (not (sequential? left)) (not(sequential? right))) false
        (nil? left) (tree? right)
        (nil? right) (tree? left)
        :else (and (tree? left) (tree? right)))
      ))
    )

; Followed solution (1067)

(fn ff [[root l r :as tree]]
   (and (= 3 (count tree))        
        (not (sequential? root))
        (or (nil? l) (and (sequential? l) (ff l)))
        (or (nil? r) (and (sequential? r) (ff r)))))

(= (tree? '(:a (:b nil nil) nil)) true)
(= (tree? '(:a (:b nil nil))) false)
(= (tree? [1 nil [2 [3 nil nil] [4 nil nil]]]) true)
(= (tree? [1 [2 [3 [4 nil nil] nil] nil ] nil]) true)
(= (tree? [1 [2 [3 [4 false nil] nil] nil ] nil]) false)
(= (tree? '(:a nil '())) false)

(defn symmetry?
  ([col] (symmetry? (second col) (last col)))
  ([l r]
   (if (and (nil? l) (nil? r))
    true
    (if (= (first l) (first r))
      (and (symmetry? (second l) (last r)) (symmetry? (second r) (last l)))
      false))))

(= (symmetry? '(:a (:b nil) (:b nil nil))) true)
(= (symmetry? '(:a (:b nil nil) nil)) false)
(= (symmetry? '(:a (:b nil nil) (:c nil nil))) false)
(= (symmetry? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                 [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
   true)
(= (symmetry? [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                 [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
   false)

; Followed solution (1067)

#((fn ff [[l-root ll lr :as left] [r-root rl rr :as right]]
    (or (= nil left right)
        (and (= l-root r-root) (ff ll rr) (ff lr rl)))) % %)


(let [
      [x [l-root ll lr :as left] [r-root rl rr :as right]]
      '(:a (:b nil nil) (:c nil nil))
      ]
  (str x " " "hi" l-root)
  )


