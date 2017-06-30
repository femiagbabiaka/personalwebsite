(ns personalwebsite.controllers.posts
    (:require [compojure.core :refer [defroutes GET]]
              [personalwebsite.views.layout :as layout]
              [ring.util.response :as ring]
              [clojure.string :as str]))



(defn index [] 
    (layout/index))

;; @TODO: Add error handling for model not found for slug.
;;(defn singlePost [slug]
;;    (when-not (str/blank? slug)
;;        (view/single (model/single slug)))
;;(ring/redirect view/postNotFound))

(defroutes routes
    (GET "/" [] (index)))
    ;;(GET "/blog/:slug" [slug] (singlePost slug))
