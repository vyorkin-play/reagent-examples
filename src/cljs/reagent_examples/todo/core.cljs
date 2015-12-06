(ns reagent-examples.todo.core
  (:require [reagent-examples.todo.session :as session :refer [todos]]
            [reagent-examples.todo.actions :as actions :refer [add save]]
            [reagent-examples.todo.components.input :as input] 
            [reagent-examples.todo.components.list :as list]))

(defn component []
  [:div
   [input/component {:on-save add
                     :placeholder "What needs to be done?"}]
   [list/component (vals @todos)]])
