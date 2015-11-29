(ns reagent-examples.bmi.component
  (:require [reagent.core :as r :refer [atom]]))

(def bmi-data (atom {:height 181 :weight 88}))

(defn calc []
  (let [{:keys [height weight bmi] :as data} @bmi-data
        h (/ height 100)]
    (if (nil? bmi)
      (assoc data :bmi (/ weight (* h h)))
      (assoc data :weight (* bmi h h )))))

(defn slider [param value min max]
  [:input {:type "range" :value value
           :min min :max max
           :style {:width "400px"}
           :on-change (fn [e]
                        (swap! bmi-data assoc param (.-target.value e))
                        (when (not= param :bmi)
                          (swap! bmi-data assoc :bmi nil)))}])

(defn component []
  (let [{:keys [weight height bmi]} (calc)
        [color diagnose] (cond
                          (< bmi 18.5) ["red" "ты дрыщь"]
                          (< bmi 25) ["green" "ты нормален"]
                          (< bmi 30) ["red " "ты жирный"]
                          :else ["red" "ты сраная жиробасина"])]
    [:div
     [:div
      "рост: " (int height) "см"
      [slider :height height 100 220]]
     [:div
      "вес: " (int weight) "кг"
      [slider :weight weight 30 150]]
     [:div
      "bmi: " (int bmi) " "
      [:span {:style {:color color}} diagnose]
      [slider :bmi bmi 10 50]]]))
