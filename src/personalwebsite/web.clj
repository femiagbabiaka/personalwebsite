(ns personalwebsite.web
  (:require [compojure.core :refer [defroutes GET]]
            [ring.adapter.jetty :as ring]))

(defn -main []
  (ring/run-jetty #'routes {:port 8080 :join? false}))