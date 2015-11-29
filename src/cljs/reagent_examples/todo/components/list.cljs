(ns reagent-examples.todo.components.list
  (:require [reagent-examples.todo.components.item :as item]))

(defn component [todos]
  [:ul#todo-list
   (for [todo todos]
     ^{:key (:id todo)} [:li (:text todo)])])
