(meditations
  "To split a collection you can use the partition function"
  ;over a range of 4 partion in to 2 
  (= '((0 1) (2 3)) (partition 2 (range 4)))

  "But watch out if there is not enough elements to form n sequences"
  (= '((:a :b :c)) (partition 3 [:a :b :c :d :e]))

  "You can use partition-all to also get partitions with less then n elements"
  (= '((0 1 2) (3 4)) (partition-all 3 (range 5)))

  "If you need to, you can start each sequence with an offset"
  ;partion by 3 and move 5 on each partion
  (= '((0 1 2) (5 6 7) (10 11 12)) (partition 3 5 (range 13)))

  "Consider padding the last sequence with some default values.."
  ;pad the end with [:hello]
  (= '((0 1 2) (3 4 5) (6 :hello)) (partition 3 3 [:hello] (range 7)))

  ".. but notice that they will only pad up to given sequence length"
  ;same as above but only as far as it goes
  (= '((0 1 2) (3 4 5) (6 :this :are)) (partition 3 3 [:this :are "my" "words"] (range 7)))
  
)
