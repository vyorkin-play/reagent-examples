(ns reagent-examples.todo.actions
  (:require [reagent-examples.todo.helpers :as helpers :refer [next-id]]))

(defonce todos (atom (sorted-map)))

(defn todo-add [text]
  (let [id (next-id)
        todo {:id id :text text :completed false}]
    (swap! todos assoc id todo)))

(defn todo-complete [id]
  (swap! todos update-in [id :completed] not))

(defn todo-edit [id title]
  (swap! todos assoc-in [id :title]))

(defn todo-delete [id]
  (swap! todos dissoc id))

(defonce init
  (do
   (todo-add "Learn some shit")
   (todo-add "Write some shit")
   (todo-add "Die")))
