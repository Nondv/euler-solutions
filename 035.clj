;; 35. Circular primes
;;
;; The number, 197, is called a circular prime because all rotations of the digits:
;; 197, 971, and 719, are themselves prime.
;;
;; There are thirteen such primes below 100:
;; 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
;;
;; How many circular primes are there below one million?

(load-file "000-utils.clj")

(def primes (utils/eratosthenes-sieve 1000000))

(defn possible-circular-numbers [x]
  (let [digits (utils/digits x)
        size (count digits)
        cycled (cycle digits)]
    (->> (range size)
         (map #(take size (drop % cycled)))
         (map (fn [variation-digits]
                (reduce #(+ (* %1 10) %2) 0 variation-digits)))
         distinct)))

(println
 (->> primes
      (group-by #(sort (possible-circular-numbers %)))
      (filter #(= (key %) (sort (val %))))
      (mapcat second)
      count))
