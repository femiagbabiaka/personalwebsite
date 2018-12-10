(ns personalwebsite.controllers.posts
    (:require [compojure.core :refer [defroutes GET]]
              [personalwebsite.views.layout :as layout]
              [ring.util.response :as ring]
              [clojure.string :as str]
              [clojure.java.io :as io]))



(defn index []
    (layout/index))

(defn is-valid-slug? [slug]
  (cond
    (str/blank? slug) false
    (.exists (io/as-file (str "/srv/personalwebsite/docs/" slug ".md"))) true
    :else false))

;; @TODO: Add error handling for model not found for slug.
(defn singlePost [slug]
  (if (is-valid-slug? slug)
    (layout/single slug)
    (layout/postNotFound)))

(defroutes routes
    (GET "/" [] (index))
    (GET "/blog/:slug" [slug] (singlePost slug)))
