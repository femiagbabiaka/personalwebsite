(defproject personalwebsite "0.3.0-SNAPSHOT"
  :description "The personal website for Femi Agbabiaka."
  :url "https://github.com/femiagbabiaka/personalwebsite"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [ring/ring-jetty-adapter "1.7.0"]
                 [ring/ring-defaults "0.3.2"]
                 [compojure "1.6.1"]
                 [ring "1.7.1"]
                 [hiccup "1.0.5"]
                 [markdown-to-hiccup "0.6.0"]]
  :main ^:skip-aot personalwebsite.web
  :uberjar-name "personalwebsite-standalone.jar"
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler personalwebsite.web/application}
  :profiles {:uberjar {:aot :all}})
