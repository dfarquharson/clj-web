(ns hello-world.handler
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [hello-world.templates :refer [tpl-helloworld]]))

(defroutes app-routes
  (GET "/" [] (tpl-helloworld "Hello World"))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (handler/site app-routes))
