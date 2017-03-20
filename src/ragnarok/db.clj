(ns ragnarok.db
  )

(def spec
  {:classname "org.h2.Driver"
   :subprotocol "h2"
   :subname "mem"})

(def schema
  (str "CREATE TABLE arcana ()")
