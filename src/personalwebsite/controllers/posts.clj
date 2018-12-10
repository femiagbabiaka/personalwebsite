(ns personalwebsite.controllers.posts
    (:require [compojure.core :as compojure]
              [compojure.route :as compojure-route]
              [personalwebsite.views.layout :as layout]
              [ring.util.response :as ring]
              [clojure.java.io :as io]
              [clojure.string :as str]))

(defn is-valid-slug? [slug]
  (cond
    (str/blank? slug) false
    (.exists (io/as-file (str "/srv/personalwebsite/docs/" slug ".md"))) true
    :else false))

(defn singlePost [slug]
  (if (is-valid-slug? slug)
    (layout/single slug)
    (layout/postNotFound)))

(compojure/defroutes routes
    (compojure/GET "/" [] (layout/index))
    (compojure/GET "/blog" [] (layout/blogPage))
    (compojure/GET "/blog/:slug" [slug] (singlePost slug))
    (compojure-route/not-found (layout/postNotFound)))
