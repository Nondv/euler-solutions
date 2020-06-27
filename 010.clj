;; 10. Summation of primes
;;
;; The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
;;
;; Find the sum of all the primes below two million.

(load-file "000-utils.clj")

(println
 (reduce + (utils/eratosthenes-sieve 2000000)))
