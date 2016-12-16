(ns personalwebsite.views.layout
    (:require [hiccup.page :as h]))


;; TODO build navigation bar component.
(defn navigationBar)

(defn basePage [title & body]
    (h/html5
        [:head
         [:meta {:charset "utf-8"}]
         [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
         [:meta {:name "viewport" :content
                    "width=device-width, initial-scale=1, maximum-scale=1"}]
         [:title title]]))