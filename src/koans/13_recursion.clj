(defn is-even? [n]
  (if (= n 0)
      true
      (not (is-even? (dec n)))))

;http://dcm8thlight.blogspot.com/2011/09/day-35.html
(defn is-even-bigint? [n]
  (loop [n   n
         acc true]
    (if (= n 0)
        acc
        (recur (dec n) (not acc)))))

(defn recursive-reverse [coll]
	(loop [coll coll
                  reversed '()]
            (if (empty? coll)
              reversed
              (recur (rest coll) (cons (first coll) reversed)))))

; start a loop with a NUM and ACC with initial values
; is it = to zero return true
; if not zero decriment num and eval until acc = true
;(defn is-even-bigint? [n]
;  (loop [num   n
;         acc true]
;    (if (zero? num)
;        acc
;        (recur (dec num) (not acc)))))
;start a loop with a collectionprop and an empty collection
; take 1 from collectionprop and add it to the empty coll
; keep going until nothing left in collprop
; once empty return emptycoll that should now be filled
;(defn recursive-reverse [coll]
;	(loop [collprop coll
;                  emptyColl '()]
;            (if (empty? collprop)
;              emptyColl
;              (recur (rest collprop) (cons (first collprop) emptyColl)))))
			  
(defn factorial [n]
	 (loop [cnt n acc 1]
       (if (zero? cnt)
            acc
          (recur (dec cnt) (* acc cnt)))))

(meditations
  "Recursion ends with a base case"
  (= true (is-even? 0))

  "And starts by moving toward that base case"
  (= false (is-even? 1))

  "Having too many stack frames requires explicit tail calls with recur"
  (= false (is-even-bigint? 100003N))

  "Reversing directions is easy when you have not gone far"
  (= '(1) (recursive-reverse [1]))

  "Yet more difficult the more steps you take"
  (= '(5 4 3 2 1) (recursive-reverse [1 2 3 4 5]))

  "Simple things may appear simple."
  (= 1 (factorial 1))

  "They may require other simple steps."
  (= 2 (factorial 2))

  "Sometimes a slightly bigger step is necessary"
  (= 6 (factorial 3))

  "And eventually you must think harder"
  (= 24 (factorial 4))

  "You can even deal with very large numbers"
  (< 1000000000000000000000000N (factorial 1000N))

  "But what happens when the machine limits you?"
  (< 1000000000000000000000000N (factorial 10000N))
  
)
