;; 5. Smallest multiple
;;
;; 2520 is the smallest number that can be divided by each of the numbers from 1 to
;; 10 without any remainder.
;;
;; What is the smallest positive number that is evenly divisible by all of the
;; numbers from 1 to 20?

(load-file "000-utils.clj")

(def sieve (utils/eratosthenes-sieve 20))
(defn prime-factors [n]
  (filter
    #(zero? (mod n %))
    (take-while #(>= % n) sieve)))

(defn factor-power [n factor]
  (loop [x n, result 0]
    (if (zero? (mod x factor))
      (recur (/ x factor) (inc result))
      result)))

(defn prime-factors [n]
  (reduce
    (fn [acc factor]
      (let [power (factor-power n factor)]
        (if (= power 0)
          acc
          (assoc acc factor power))))
    {}
    sieve))

(def result-prime-factors
  (reduce
    #(merge-with max %1 (prime-factors %2))
    {}
    (range 2 21)))

(def result
  (int (reduce-kv #(* %1 (Math/pow %2 %3)) 1 result-prime-factors)))

(println result)
