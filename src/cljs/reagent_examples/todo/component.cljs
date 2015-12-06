(ns reagent-examples.todo.component
  (:require [reagent.core :as r :refer [atom]]
            [clojure.string :as s :refer [trim]]))

(defonce todos (atom (sorted-map)))
(defonce counter (atom 0))

(def key-enter 13)
(def key-escape 27)

(defn create-todo [title]
  (let [id (swap! counter inc)]
    (swap! todos assoc id {:id id :title title :done false})))

(defn update-todo [id title]
  (swap! todos assoc-in [id :title] title))

(defonce init
  (do
   (create-todo "learn some shit")
   (create-todo "write some code")
   (create-todo "die")))

(defn clear-todos []
  (reset! todos ))

(defn input-render [{:keys [title on-save]}]
  (let [val (r/atom title)
        save #(let [v (-> @val str trim)]
                (when-not (empty? v) (on-save v)))
        change #(reset! val %)
        key-down #(condp = %
                    key-enter (save)
                    nil)]
    (fn [props]
      [:input (merge props
                     {:type "text"
                      :value @val
                      :on-change #(change (-> % .-target .-value))
                      :on-key-down #(key-down (.-which %))})])))

(defn input-did-mount [c]
  (.focus (r/dom-node c)))

(defn input-component []
  (r/create-class {:reagent-render input-render
                   :component-did-mount input-did-mount}))

(defn todo-item [{:keys [id title]}]
  ^{:key id} [:li title])

(defn component []
  [:div
   [input-component {:on-save create-todo
                :placeholder "What needs to be done?"}]
   [:ul.todos
    (for [todo (vals @todos)]
      (todo-item todo))]])
