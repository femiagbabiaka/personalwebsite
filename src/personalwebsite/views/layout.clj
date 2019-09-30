(ns personalwebsite.views.layout
  (:require [hiccup.page :as h]
            [markdown-to-hiccup.core :as m]
            [clojure.java.io :as io]))

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
     [:li {:style "display: inline; padding: 14px 16px;" } [:a {:style "color: blue;" :href "https://github.com/femiagbabiaka" :target "_blank"} "github"]]
     [:li {:style "display: inline; padding: 14px 16px;" } [:a {:style "color: blue;" :href "https://www.linkedin.com/in/femi-agbabiaka-5b5984108" :target "_blank"} "linkedin"]]]))

(defn basePage [title & body]
  (header title)
  (h/html5
    [:body
     [:div {:id "header"}
      [:h1 {:class "container"} title]]
     [:div {:id "content" :class "container"} (navigationBar) body]]))

(defn postNotFound []
  (basePage "hopelessly lost"
            [:p {:style "font-size:150%"} "you seem to have lost your way. here's a path " 
             [:a {:style "color: blue;" :href "/"} "home"] "."]))

(defn list-directories [directory] 
  (->> directory
       io/file
       file-seq
       (filter #(.isDirectory %))
       (map #(.getName %))
       (filter #(not (re-matches #"docs" %)))))

(defn list-files [directory]
  (->> directory
       io/file
       file-seq
       (filter #(.isFile %))
       (map #(.getName %))
       (filter #(re-matches #".*\.md" %))))

(defn blogPage []
  (basePage "categories"
            [:ul 
             (for [post (list-directories "/srv/personalwebsite/docs/")]
               [:li 
                [:a { :href (str "/blog/" post) :style "color: blue;"} post]])]))

(defn folderPage [slug]
  (basePage (str slug)
            [:ul 
             (for [post (list-files (str "/srv/personalwebsite/docs/" slug))]
               [:li 
                [:a { :href (str "/blog/" slug "/" post) :style "color: blue;"} post]])]))


(defn single [folder slug]
  (basePage (str slug)
            (->>
              (m/file->hiccup (str "/srv/personalwebsite/docs/" folder "/" slug))
              (m/component))))

(defn index []
  (basePage "howdy doody"
            [:div {:id "it-me"}
             [:p "hello, my name is femi agbabiaka."]
             [:p "i " [:a {:href "/blog" :style "color:blue;"} "blog"] " here. i'm mostly interested in music and philosophy. I also enjoy hiking quite a bit, if you have any trail recs, please " [:a {:href "mailto:femi@femiagbabiaka.xyz" :style "color:blue;"} "email me"]]
             [:p "currently, i work at " [:a {:href "https://mode.com/careers/" :style "color:blue;"} "mode analytics"] " as a Site Reliability Engineer. I'm always willing to talk about my workplace."]
                        [:p "if you're looking to contact me, you can email me at "
              [:a {:href "mailto:femi@femiagbabiaka.xyz"} "femi@femiagbabiaka.xyz"] "."]
             [:p {:style "font-size:28%"} "ps, this website is built using clojure, also, socialism will win"]]))
