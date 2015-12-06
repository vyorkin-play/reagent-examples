(ns reagent-examples.todo.components.input
  (:require [reagent.core :as r :refer [atom]]
            [clojure.string :as s :refer [trim]]
            [reagent-examples.todo.helpers :as helpers :refer [key-enter key-escape]]))

(defn did-mount [c]
  (.focus (r/dom-node c)))

(defn render [{:keys [title on-save]}]
  (let [val (r/atom title)
        clear #(reset! val "")
        save #(let [v (-> @val str trim)]
                (when-not (empty? v)
                  (do (on-save v)
                      (clear))))
        change #(reset! val %)
        key-down #(condp = %
                    key-enter (save)
                    key-escape (clear)
                    nil)]
    (fn [props]
      [:input#todo-new (merge props
                     {:type "text"
                      :value @val
                      :on-change #(change (-> % .-target .-value))
                      :on-key-down #(key-down (.-which %))})])))

(defn component []
  (r/create-class {:reagent-render render
                   :component-did-mount did-mount}))
