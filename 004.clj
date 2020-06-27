;; A palindromic number reads the same both ways.
;; The largest palindrome made from the product of
;; two 2-digit numbers is 9009 = 91 × 99.

;; Find the largest palindrome made from the product of two 3-digit numbers.

(defn digits [n]
  (loop [x n, result '()]
    (if (= x 0)
      result
      (recur (quot x 10) (conj result (mod x 10))))))

(def largest (* 999 999))
(def lowest (* 100 100))

(defn is-palindrome? [x]
  (->> (digits x)
       (#(= % (reverse %)))))

(def products
  (let [r (range 100 1000)]
    (for [a r
          b r]
      (* a b))))

(println (first (filter is-palindrome? (sort-by - products))))
