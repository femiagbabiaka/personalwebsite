(defproject personalwebsite "0.1.0-SNAPSHOT"
  :description "The personal website for Femi Agbabiaka."
  :url "https://github.com/femiagbabiaka/personalwebsite"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/java.jdbc "0.6.1"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.2.1"]
                 [hiccup "1.0.5"]]
  :main ^:skip-aot personalwebsite.web
  :uberjar-name "personalwebsite-standalone.jar"
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler personalwebsite.web/application}
  :profiles {:uberjar {:aot :all}})
