;; 6. Sum square difference
;;
;; The sum of the squares of the first ten natural numbers is,
;; \begin{equation}
;; 1^2 + 2^2 + ... + 10^2 = 385
;; \end{equation}
;;
;; The square of the sum of the first ten natural numbers is,
;;
;; \begin{equation}
;; (1 + 2 + ... + 10)^2 = 55^2 = 3025
;; \end{equation}
;;
;; Hence the difference between the sum of the squares of the first ten natural
;; numbers and the square of the sum is 3025 − 385 = 2640.
;;
;; Find the difference between the sum of the squares of the first one hundred
;; natural numbers and the square of the sum.


;; NAIVE SOLUTION

(def numbers (range 1 101))
(defn sqr [x] (* x x))

(println (- (sqr (reduce + numbers)) (reduce #(+ %1 (sqr %2)) 0 numbers)))
