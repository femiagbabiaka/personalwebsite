(ns personalwebsite.controllers.posts
    (:require [compojure.core :as compojure]
              [compojure.route :as compojure-route]
              [personalwebsite.views.layout :as layout]
              [ring.util.response :as ring]
              [clojure.java.io :as io]
              [clojure.string :as str]))

(defn is-valid-folder? [slug]
  (cond
    (str/blank? slug) false
    (.exists (io/as-file (str "/srv/personalwebsite/docs/" slug))) true
    :else false))

(defn is-valid-post? [folder slug]
  (cond
    (str/blank? slug) false
    (str/blank? folder) false
    (.exists (io/as-file (str "/srv/personalwebsite/docs/" folder "/" slug))) true
    :else false))

(defn singleFolder [slug]
  (if (is-valid-folder? slug)
    (layout/folderPage slug)
    (layout/postNotFound)))

(defn singlePost [folder slug]
  (if (is-valid-post? folder slug)
    (layout/single folder slug)
    (layout/postNotFound)))

(compojure/defroutes routes
    (compojure/GET "/" [] (layout/index))
    (compojure/GET "/blog" [] (layout/blogPage))
    (compojure/GET "/blog/:folder" [folder] (singleFolder folder))
    (compojure/GET "/blog/:folder/:post" [folder post] (singlePost folder post))
    (compojure-route/not-found (layout/postNotFound)))
