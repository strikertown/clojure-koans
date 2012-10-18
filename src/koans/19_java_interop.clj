(meditations
  "You may have done more with Java than you know"
  (= java.lang.String (class "warfare")) ; hint: try typing (javadoc "warfare") in the REPL

  "The dot signifies easy and direct Java interoperation"
  (= "SELECT * FROM" (.toUpperCase "select * from"))

  "But instance method calls are very different from normal functions"
  ;function to take in prop and toupper it
  (= ["SELECT" "FROM" "WHERE"] (map #(.toUpperCase %) ["select" "from" "where"]))

  "Constructing might be harder than breaking"
  ;10 = 10 why
  (= 10 (let [latch (java.util.concurrent.CountDownLatch. 10)]
          (.getCount latch)))

  "Static methods are slashing prices!"
  ;why
  (== 1024 (Math/pow 2 10))
  
)
