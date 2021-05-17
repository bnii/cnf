(ns cnf.core
  {:no-doc true}
  (:require [net.cgrand.enlive-html :as html]
            [clj-http.lite.client :as client])
  (:import (java.io StringReader))
  (:gen-class))

(set! *warn-on-reflection* true)

(defn get-html [cmd]
  (client/get
    (str "https://command-not-found.com/" cmd)
    {:headers {"User-Agent" "curl/7"}}))

(defn parse-html [html-text]
  (html/html-resource (StringReader. (:body html-text))))

(defn get-install-cmd [parsed-html system]
  (first
    (html/select
      (first (html/select parsed-html {[(keyword (str ".install-" system))] [[:dd]]}))
      [:dd :code html/text])))


(defn -main [& args]
  (println
    (get-install-cmd
      (parse-html (get-html (first args)))
      "osx")))


(comment
  (get-install-cmd (parse-html (get-html "ts")) "fedora")
  (require '[vlaaad.reveal :as reveal])
  (add-tap (reveal/ui)))

