(defproject cnf "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url  "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.martinklepsch/clj-http-lite "0.4.3"]
                 [enlive "1.1.6"]
                 [xml-sax/xml-sax "0.1.0"]]
  :profiles {:uberjar {:global-vars {*assert* false}
                       :jvm-opts    ["-Dclojure.compiler.direct-linking=true"
                                     "-Dclojure.spec.skip-macros=true"]
                       :aot         :all}
             :tracing {:jvm-opts ["-agentlib:native-image-agent=config-output-dir=."]}}
  :main cnf.core
  :repl-options {:init-ns cnf.core})
