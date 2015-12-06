(ns reagent-examples.todo.components.item
  (:require [reagent.core :as r :refer [atom]]
            [reagent-examples.todo.components.edit :as edit]
            [reagent-examples.todo.actions :as actions :refer [toggle delete]]))

(defn class-name [completed editing]
  (str (when completed "completed")
       (when editing "editing")))

(defn checkbox [id completed]
  [:input.toggle {:type "checkbox"
                  :checked completed
                  :on-change #(toggle id)}])

(defn component []
  (let [editing (atom false)]
    (fn [{:keys [id title completed]}]
      [:li {:class (class-name completed @editing)}
       [:div.view
        [checkbox id completed]
        [:label title]]
       [:button.destroy {:on-click #(delete id)} "X"]])))
