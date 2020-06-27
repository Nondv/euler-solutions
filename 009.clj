;; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
;; a2 + b2 = c2
;;
;; For example, 32 + 42 = 9 + 16 = 25 = 52.
;;
;; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;; Find the product abc.




;; Geometry: in a triangle abc a < (b + c)
;; In this case neither of sides can be bigger than 500.
;;
;; When we pick a side a (< 500) we can iterate on the possible other two.
;; Considering we can't go above 500 and we also don't want to do double checking for
;; [b, c] and [c, b] we can go from (1000 - a) / 2 up to 500


;; let's assume a > b >= c (a != b because it's a hypothenuse).
(def triangles
  (mapcat
   (fn [a]
     (->> (range (int (Math/ceil (/ (- 1000 a) 2))) a)
          (map (fn [b]
                 (when (> 500 (- 1000 a b))
                   [a b (- 1000 a b)])))
          (remove nil?)))
   ;; This range could be optimised but I cba do the math
   (range 500)))

(println
 (->> triangles
      (filter (fn [[a b c]] (= (* a a) (+ (* b b) (* c c)))))
      first
      (reduce * 1)))
