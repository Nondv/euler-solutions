(ns utils)

(defn eratosthenes-sieve
  ([n] (eratosthenes-sieve (list 2) #{} n))
  ([sieve composites-set n]
    (let [prime (first sieve)
          next-composites-set (loop [i (+ prime prime), result composites-set]
                                (if (> i n) result (recur (+ i prime) (conj result i))))

          is-prime? #(not (contains? next-composites-set %))

          ;; next-prime (first (filter is-prime? (iterate inc (inc prime))))
          next-prime (loop [x (inc prime)] (if (is-prime? x) x (recur (inc x))))]
      (if (> next-prime n)
        sieve
        (recur (cons next-prime sieve) next-composites-set n)))))



(defn next-prime [primes]
  (let [is-prime? (fn [x]
                    (let [sqrt (Math/sqrt x)]
                      (not-any? #(zero? (mod x %))
                                (take-while #(<= % sqrt) primes))))]
    (->> (inc (last primes))
         (iterate inc)
         (filter is-prime?)
         first)))

(->> [2]
     (iterate #(conj % (next-prime %)))
     (map last)
     (take 10))



(defn digits [n]
  (loop [x n, result '()]
    (if (= x 0)
      result
      (recur (quot x 10) (conj result (mod x 10))))))
