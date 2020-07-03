;; 15. Lattice paths
;;
;; Starting in the top left corner of a 2×2 grid, and only being able to move to the right and down
;; there are exactly 6 routes to the bottom right corner.
;; How many such routes are there through a 20×20 grid?


;; All routes will always have the same amount of rights and downs.
;; This means every route is just a combination of those.
;; Hello, combinatorics.
;;
;; For a grid NxN we will have exactly N downs and N rights.
;; Number of combinations of 2N elements is `(N + N)!`.
;; However, the elements are not all different. we have only two types of them.
;; So the result will be: `(N + N)! / (N! * N!)`.
;; Which can be a bit optimised:
;; `(N+1) * (N+2) ... * 2N / N!`
(defn fact [n]
  (reduce * 1 (range 2 (inc n))))

(def N (bigdec 20))

(println (/ (reduce * 1 (range (inc N) (+ N N 1)))
            (fact N)))
