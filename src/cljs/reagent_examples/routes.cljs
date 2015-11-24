(ns reagent-examples.routes
  (:require [reagent.session :as session]
            [secretary.core :as secretary :include-macros true]
            [reagent-examples.pages :as pages]))

(secretary/defroute "/" [] (session/put! :current-page pages/home))
(secretary/defroute "/counter" [] (session/put! :current-page pages/counter))
(secretary/defroute "/todo" [] (session/put! :current-page pages/todo))
