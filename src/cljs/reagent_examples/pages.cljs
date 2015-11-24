(ns reagent-examples.pages
  (:require [reagent-examples.counter.component :as counter]
            [reagent-examples.todo.components.app :as todo]))

(defn navigation []
  [:ul
   [:li [:a {:href "/counter"} "counter"]]
   [:li [:a {:href "/todo"} "todo"]]])

(defn home []
  [:div [:h2 "index"]
   [navigation]])

(defn counter []
  [:div [:h2 "counter"]
   [counter/component]])

(defn todo []
  [:div [:h2 "todo"]
   [:div [:a {:href "/"} "index"]
    [:div [todo/component]]]])
