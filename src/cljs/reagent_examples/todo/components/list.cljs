(ns reagent-examples.todo.components.list
  (:require [reagent-examples.todo.components.item :as item]))

(defn component [items]
  [:div
   (map #([item/component %]) items)])
