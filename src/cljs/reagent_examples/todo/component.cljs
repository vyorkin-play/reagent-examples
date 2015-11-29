(ns reagent-examples.todo.component
  (:require [reagent.core :as r :refer [atom]]))

(defonce todos (atom (sorted-map)))
(defonce counter (atom 0))

(defn add-todo [text]
  (let [id (swap! counter inc)]
    (swap! todos assoc id {:id id :title text :done false})))

(defonce init (do
               (add-todo "One")
               (add-todo "Two")))

(defn todo-input []
  [:div "input"])

(defn component []
  [:div
   (todo-input)
   [:ul.todos
    (for [todo (vals @todos)]
      ^{:key (:id todo)} [:li (:title todo)])]])
