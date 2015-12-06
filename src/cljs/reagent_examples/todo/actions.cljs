(ns reagent-examples.todo.actions
  (:require [reagent-examples.todo.session :as session :refer [todos counter]]))

(defn next-id [] (swap! counter inc))

(defn add [title]
  (let [id (next-id)
        todo {:id id
              :title title
              :done false}]
    (swap! todos assoc id todo)))

(defn save [id title]
  (swap! todos assoc-in [id :title] title))
