(ns hello-world.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))

(defn hello [s]
  (str "Hello " s "!\n"))

(def repo-dir "/Users/djfarquharson/repos/")

(defn repo-exists [repo]
  (.exists (clojure.java.io/as-file (str repo-dir repo))))

(def repo-list (file-seq (clojure.java.io/file repo-dir)))

(defroutes app-routes
  (GET "/" [] "Home Page\n")
  (GET "/hello" [] "Hello world!\n")
  (GET "/hello/:user" [user] (hello user))
  (GET "/repo" [] (map #(str % "\n") (take 10 repo-list)))
  (GET "/repo-exists/:repo" [repo] (str (repo-exists repo) "\n"))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
