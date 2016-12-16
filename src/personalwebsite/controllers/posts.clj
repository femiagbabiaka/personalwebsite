(ns personalwebsite.controllers.posts
    (:require [compojure.core :refer [defroutes GET]]
              [personalwebsite.views.posts :as view]
              [personalwebsite.views.layout :as layout]
              [ring.util.response :as ring]
              [personalwebsite.models.posts :as model]))


(defn index [] 
    (view/index (model/all)))

;; @TODO: Add error handling for model not found for slug.
(defn singlePost [slug]
    (when-not (str/blank? slug)
        (view/single (model/single slug)))
    (ring/redirect view/postNotFound))

(defroutes routes
    (GET "/" [] (index)
    (GET "/blog/:slug" [slug] (singlePost slug))))