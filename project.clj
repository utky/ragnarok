(defproject ragnarok "0.1.0-SNAPSHOT"
  :description "You know Tsushima Yoshiko is the best school idol."
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/data.json "0.2.6"]
                 [compojure "1.5.1"]
                 [ring/ring-core "1.5.0"]
                 [ring/ring-jetty-adapter "1.5.0"]
                 [ring/ring-defaults "0.2.1"]
                 [com.h2database/h2 "1.4.193"]
                 [clj-yaml "0.4.0"]
                 [org.clojure/java.jdbc "0.7.0-alpha1"]]
  :plugins [[lein-ring "0.9.7"]]
  :ring {:handler ragnarok.main/application}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.0"]]}})
