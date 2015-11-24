(ns reagent-examples.counter.actions
  (:require [reagent.core :as r :refer [atom]]))

(defonce counter (atom 0))

(defn up [] (swap! counter inc))
(defn down [] (swap! counter dec))
