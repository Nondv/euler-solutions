;; A palindromic number reads the same both ways.
;; The largest palindrome made from the product of
;; two 2-digit numbers is 9009 = 91 × 99.

;; Find the largest palindrome made from the product of two 3-digit numbers.

(load-file "000-utils.clj")


(def largest (* 999 999))
(def lowest (* 100 100))

(defn is-palindrome? [x]
  (->> (utils/digits x)
       (#(= % (reverse %)))))

(def products
  (let [r (range 100 1000)]
    (for [a r
          b r]
      (* a b))))

(println (first (filter is-palindrome? (sort-by - products))))
