(ns ragnarok.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :as response]))

(defroutes app-routes
  (GET "/" []
       (response/content-type
         (response/resource-response "index.html" {:root "public"})
         "text/html"))
  (GET "/search" request
       (fn [request] 
         (let [q (get (:query-params request) "q")]
           (str "Hello world: " q))))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
