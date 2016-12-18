(ns personalwebsite.views.layout
    (:require [hiccup.page :as h]))


;; TODO build navigation bar component.
;;(defn navigationBar)

(defn basePage [title & body]
    (h/html5
        [:head
            [:meta {:charset "utf-8"}]
            [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
            [:meta {:name "viewport" :content
                    "width=device-width, initial-scale=1, maximum-scale=1"}]
            [:title title]]
            [:body 
                [:div {:id "header"}
                    [:h1 {:class "container"} "femi's website"]]
                [:div {:id "content" :class "container"} body]]))

(defn index []
    (basePage "femi"
        [:div {:id "it-me"}
            [:p "hello, my name is femi agbabiaka"]
            [:p "i'm a software engineer who loves infrastructure, all things devops, and long walks on the beach"]
            [:p "currently, i work at " [:a {:href "http://activecampaign.com" :style "color:blue;"} "ActiveCampaign"] "."]
            [:p "i'm also a member of the " [:a {:href "www.dsausa.org" :style "color: blue;"} "Democratic Socialists of America"] "."] 
            [:p "if you're looking to contact me, you can email me at "
                [:a {:href "mailto:femi@femiagbabiaka.xyz"} "femi@femiagbabiaka.xyz"] "."]
            [:ul
                [:li "github: " [:a {:style "color: blue;" :href "https://github.com/femiagbabiaka"} "femi's github"]]
                [:li "linkedin: " [:a {:style "color: blue;" :href "https://www.linkedin.com/in/femi-agbabiaka-5b5984108"} "femi's linkedin"]]]
            [:p {:style "font-size:80%"} "ps, this website is built using clojure"]]))
