(defproject hello-world "0.1.0-SNAPSHOT"
  :description "Clojure port of xtl-compilation-service"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [enlive "1.1.1"]]
  :plugins [[lein-ring "0.8.11"]]
  :ring {:handler hello-world.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
