(ns personalwebsite.web
  (:require [compojure.core :refer [defroutes GET]]
            [ring.adapter.jetty :as ring]
            [personalwebsite.controllers.posts :as controller]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]])
            (:gen-class))


(defroutes routes 
  controller/routes)

(def application (wrap-defaults routes site-defaults))

(defn start [port] 
  (ring/run-jetty application {:port port
                               :join? false}))

(defn -main []
  (let [port (Integer. (or (System/getenv "PORT") "8080"))]
    (start port)))