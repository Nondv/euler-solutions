;; 31. Coin sums
;;
;; In England the currency is made up of pound, £, and pence, p, and there are
;; eight coins in general circulation:
;;
;; 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
;;
;; It is possible to make £2 in the following way:
;;
;; 1×£1 + 1×50p + 2×20p + 1×5p + 1×2p + 3×1p
;;
;; How many different ways can £2 be made using any number of coins?

(def values (list 1 2 5 10 20 50 100 200))

(defn ways [n coin-types]
  (if (empty? coin-types)
    (if (= n 0) 1 0)
    (reduce
      #(+ %1 (ways (- n %2) (rest coin-types)))
      0
      (range 0 (inc n) (first coin-types)))))

(println (ways 200 values))
