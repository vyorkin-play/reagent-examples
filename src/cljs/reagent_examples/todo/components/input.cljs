(ns reagent-examples.todo.components.input
  (:require [reagent.core :as r :refer [atom]]
            [reagent-examples.todo.actions :as actions]
            [reagent-examples.todo.helpers :as helpers :refer [keyboard]]))

(defn on-key-down [k text]
  (let [enter (keyboard :enter)
        key-code (.-which k)]
    (condp = key-code
      enter (actions/add text)
      nil)))

(defn did-mount [x]
  (.focus (r/dom-node x)))

(defn render []
  (let [text (atom "")]
    (fn []
      [:input#todo-new {:type "text"
                        :placeholder "What needs to be done?"
                        :value @text
                        :on-change #(reset! text (-> % .-target .-value))
                        :on-key-down #(on-key-down % text)}])))

(defn component []
  (r/create-class {:reagent-render render
                   :component-did-mount did-mount}))
