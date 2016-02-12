(ns auth-server.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [selmer.middleware :refer [wrap-error-page]]
            [selmer.parser :refer [render-file]]
            [environ.core :refer [env]]))

(defroutes app-routes
  (GET "/" [] (render-file "templates/hello.html" {:name "foo"}))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults)
  )

;;#(if (env :dev) (wrap-error-page %) %)


