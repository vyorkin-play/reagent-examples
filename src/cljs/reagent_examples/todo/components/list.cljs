(ns reagent-examples.todo.components.list
  (:require [reagent-examples.todo.components.item :as item]))

(defn component [todos]
  [:ul.todos
   (for [todo todos]
     ^{:key (:id todo)} [item/component todo])]) 
