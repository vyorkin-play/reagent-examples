(ns reagent-examples.todo.components.input
  (:require [reagent.core :as r :refer [atom]]
            [reagent-examples.todo.actions :as actions]))

(defn component []
  [:h1 "input"])

; (defn todo-input []
;   (let [default ""
;         text (atom "")
;         save #(let [v (-> @text str clojure.string/trim)] (todo-add v))]
;     (fn []
;       [:input#todo-new {:type "text"
;                         :placeholder "What neeeds to be done?"
;                         :value @text
;                         :on-blur save
;                         :on-change #(reset! text (-> % .-target .-value))}])))

; (defn component [])
