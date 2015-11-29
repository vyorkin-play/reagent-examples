(ns reagent-examples.todo.components.app
  (:require [reagent-examples.todo.components.list :as list]
            [reagent-examples.todo.components.input :as input]
            [reagent-examples.todo.actions :as actions :refer [todos]]))

(defn component []
  [:div
   [input/component]
   [list/component (vals @todos)]])
