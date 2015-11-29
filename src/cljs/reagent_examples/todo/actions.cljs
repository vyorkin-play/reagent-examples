(ns reagent-examples.todo.actions
  (:require [reagent.core :as r :refer [atom]]
            [reagent-examples.todo.helpers :as helpers :refer [next-id]]))

(defonce todos (atom (sorted-map)))

(defn add [text]
  (let [id (next-id)
        todo {:id id :text text :completed false}]
    (swap! todos assoc id todo)))

(defn complete [id]
  (swap! todos update-in [id :completed] not))

(defn edit [id title]
  (swap! todos assoc-in [id :title]))

(defn delete [id]
  (swap! todos dissoc id))

(defonce init
  (do
   (add "Learn some shit")
   (add "Write some shit")
   (add "Die")))
