(def the-world (ref "hello"))
(def bizarro-world (ref {}))

(meditations
  "In the beginning, there was a word"
  (= "hello" (deref the-world))

  "You can get the word more succinctly, but it's the same"
  (= "hello" @the-world)

  "You can be the change you wish to see in the world."
  (= "better" (do
          (dosync (ref-set the-world "better"))
          @the-world))

  "Alter where you need not replace"
  "We just changed @the-world to better"
  (= "better!!!" (let [exclamator (fn [x] (str x "!"))]
          (dosync
            (alter the-world exclamator)
            (alter the-world exclamator)
            (alter the-world exclamator))
          @the-world))

  "Don't forget to do your work in a transaction!"
  ;"doseq" is almost interchangable with "for", so why have both doseq and for? The for loop 
  ;will always return a value and doseq will never return a value.
  (= 0 (do (dosync 
			(ref-set the-world 0))
			@the-world))

  "Functions passed to alter may depend on the data in the ref"
  (= 20 (do
          (dosync (alter the-world #(+ % 20)))))

  "Two worlds are better than one"
  (= ["Real Jerry" "Bizarro Jerry"]
     (do
       (dosync
         (ref-set the-world {})
         (alter the-world assoc :jerry "Real Jerry")
         (alter bizarro-world assoc :jerry "Bizarro Jerry")
		(vec (map #(:jerry @%) [the-world bizarro-world])))))
		
)

