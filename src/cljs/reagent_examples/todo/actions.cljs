(ns reagent-examples.todo.actions
  (:require [reagent-examples.todo.session :as session :refer [todos counter]]))

(defn next-id [] (swap! counter inc))

(defn add [title]
  (let [id (next-id)
        todo {:id id
              :title title
              :completed false}]
    (swap! todos assoc id todo)))

(defn save [id title]
  (swap! todos assoc-in [id :title] title))

(defn toggle [id]
  (swap! todos update-in [id :completed] not))

(defn delete [id]
  (swap! todos dissoc id))
