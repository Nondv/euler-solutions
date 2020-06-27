;; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
;; we can see that the 6th prime is 13.
;;
;; What is the 10 001st prime number?



;; I don't think the sieve would help because
;; i have no idea what amount of memory it would take
;; We can just simple calculate them one by one by following simple induction:
;; - 2 is prime.
;; - x is prime if it's not divisable by any of the previous primes.
;; - As an optimization, we don't have to go thrhough primes >=sqrt(x)


(defn next-prime [primes]
  (let [is-prime? (fn [x]
                    (let [sqrt (Math/sqrt x)]
                      (not-any? #(zero? (mod x %))
                                (take-while #(<= % sqrt) primes))))]
    (->> (inc (last primes))
         (iterate inc)
         (filter is-prime?)
         first)))

(println
 (->> [2]
      (iterate #(conj % (next-prime %)))
      (#(nth % 10000))
      last))
