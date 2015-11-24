(ns reagent-examples.todo.helpers
  (:require [reagent.core :as r :refer [atom]]))

(defonce id (atom 1))
(defn next-id [] (swap! id inc))
