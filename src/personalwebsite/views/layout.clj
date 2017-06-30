(ns personalwebsite.views.layout
  (:require [hiccup.page :as h]))

(defn header
  "The header component for our pages."
  [title]
  (h/html5
    [:head
     [:meta {:charset "utf-8"}]
     [:meta {:http-equiv "X-UA-Compatible" :content "IE=edge,chrome=1"}]
     [:meta {:name "viewport" :content "width=device-width, initial-scale=1, maximum-scale=1"}]
     [:title title]]))

(defn navigationBar
  "the navigation bar for our website"
  []
  (h/html5
    [:ul {:style "list-style-type: none; margin: 0; padding: 0;"}
     [:li {:style "display: inline; padding: 14px 16px 14px 0px;" } [:a { :href "/" :style "color: blue;"} "home"]]
     [:li {:style "display: inline; padding: 14px 16px;" } [:a {:style "color: blue;" :href "/blog"} "blog"]]
     [:li {:style "display: inline; padding: 14px 16px;" } [:a {:style "color: blue;" :href "https://github.com/femiagbabiaka"} "github"]]
     [:li {:style "display: inline; padding: 14px 16px;" } [:a {:style "color: blue;" :href "https://www.linkedin.com/in/femi-agbabiaka-5b5984108"} "linkedin"]]]))

(defn basePage [title & body]
  (header title)
  (h/html5
    [:body
     [:div {:id "header"}
      [:h1 {:class "container"} "femi's website"]]
     [:div {:id "content" :class "container"} (navigationBar) body]]))

(defn index []
  (basePage "femi"
            [:div {:id "it-me"}
             [:p "hello, my name is femi agbabiaka"]
             [:p "i'm a sre who loves infrastructure, all things devops, and long walks on the beach"]
             [:p "currently, i work at " [:a {:href "http://activecampaign.com" :style "color:blue;"} "ActiveCampaign"] "."]
             [:p "i'm also a member of the " [:a {:href "http://dsausa.org" :style "color: blue;"} "Democratic Socialists of America"] "."]
             [:p "if you're looking to contact me, you can email me at "
              [:a {:href "mailto:femi@femiagbabiaka.xyz"} "femi@femiagbabiaka.xyz"] "."]
             [:p {:style "font-size:80%"} "ps, this website is built using clojure"]]))
