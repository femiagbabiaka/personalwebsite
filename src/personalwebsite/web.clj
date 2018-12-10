(ns personalwebsite.web
  (:require [compojure.core :refer [defroutes GET]]
            [ring.adapter.jetty :as ring-adapter]
            [personalwebsite.controllers.posts :as controller]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.middleware.reload :refer [wrap-reload]])
  (:gen-class))


(defroutes routes
  controller/routes)

(def application (wrap-reload routes site-defaults))

(defn start [port]
  (ring-adapter/run-jetty application {:port port
                               :join? false}))

(defn -main []
  (let [port (Integer. (or (System/getenv "PORT") "8080"))]
    (start port)))
