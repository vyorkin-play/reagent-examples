(ns reagent-examples.core
  (:require [reagent.core :as r]
            [reagent.session :as session]
            [accountant.core :as accountant
             :refer [configure-navigation! dispatch-current!]]
            [reagent-examples.routes :as routes]
            [reagent-examples.pages :as pages]))

(defn current-page []
  [:div [(session/get :current-page)]])

(defn mount-root []
  (r/render [current-page]
            (.getElementById js/document "app")))

(defn init! []
  (configure-navigation!)
  (dispatch-current!)
  (mount-root))
