(ns reagent-examples.timer.component
  (:require [reagent.core :as r :refer [atom]]
            [clojure.string :as str]))

(defonce timer (atom (js/Date.)))
(defonce time-color (atom "#444"))
(defonce time-updater (js/setInterval #(reset! timer (js/Date.)) 100))

(defn clock []
  (let [time-str (-> @timer .toTimeString (str/split " ") first)]
    [:div.clock {:style {:color @time-color}} time-str]))

(defn color-input []
  [:div.color
   "color: "
   [:input {:type "text"
            :value @time-color
            :on-change #(reset! time-color (-> % .-target .-value))}]])

(defn component []
  [:div
   [:h3 "timer"]
   [clock]
   [color-input]])
