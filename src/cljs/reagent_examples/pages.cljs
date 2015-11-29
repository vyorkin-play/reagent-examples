(ns reagent-examples.pages
  (:require [reagent-examples.counter.component :as counter]
            [reagent-examples.bmi.component :as bmi]
            [reagent-examples.timer.component :as timer]
            [reagent-examples.todo.component :as todo]))

(defn navigation []
  [:ul
   [:li [:a {:href "/counter"} "counter"]]
   [:li [:a {:href "/bmi"} "bmi"]]
   [:li [:a {:href "/timer"} "timer"]]
   [:li [:a {:href "/todo"} "todo"]]])

(defn home []
  [:div [:h2 "index"]
   [navigation]])

(defn counter []
  [:div [:h2 "counter"]
   [counter/component]])

(defn timer []
  [:dev [:h2 "timer"]
   [timer/component]])

(defn bmi []
  [:div [:h2 "узнай, насколько ты жирный"]
   [bmi/component]])

(defn todo []
  [:div [:h2 "todo"]
    [todo/component]])
