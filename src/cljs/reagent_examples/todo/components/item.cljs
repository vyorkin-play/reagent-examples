(ns reagent-examples.todo.components.item)

(defn component [todo]
  ^{:key (:id todo)} [:li (:text todo)])
