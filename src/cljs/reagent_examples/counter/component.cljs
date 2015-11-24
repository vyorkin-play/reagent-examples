(ns reagent-examples.counter.component
  (:require [reagent-examples.counter.actions :as actions :refer [counter up down]]))

(defn component []
  [:div
   [:h3 @counter]
    [:button {:on-click up} "up"]
    [:button {:on-click down} "down"]])
