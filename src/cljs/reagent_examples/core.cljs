(ns reagent-examples.core
    (:require [reagent.core :as r :refer [atom]]
              [reagent.session :as session]
              [secretary.core :as secretary :include-macros true]
              [accountant.core :as accountant]))

;; -------------------------
;; Common

(defonce next-id (atom 1))

;; -------------------------
;; Counter

(defonce counter (atom 0))
(defn up [] (swap! counter inc))
(defn down [] (swap! counter dec))

;; -------------------------
;; Todo

(defonce todos (atom (sorted-map)))

;; Actions

(defn todo-next-id [] (swap! next-id inc))

(defn todo-add [text]
  (let [id (todo-next-id)
        todo {:id id :text text :completed false}]
    (swap! todos assoc id todo)))

(defn todo-complete [id]
  (swap! todos update-in [id :completed] not))

(defn todo-edit [id title]
  (swap! todos assoc-in [id :title]))

(defn todo-delete [id]
  (swap! todos dissoc id))

(defonce init
  (do
   (todo-add "Learn some shit")
   (todo-add "Write some shit")
   (todo-add "Die")))

;; Components

(defn todo-app []
  (let [items (vals @todos)]
    [:ul
     (map (fn [v] [:li (:text v)]) items)]))

;; -------------------------
;; Pages

(defn home-page []
  [:div [:h2 "index"]
   [:ul
    [:li [:a {:href "/counter"} "counter"]]
    [:li [:a {:href "/todo"} "todo"]]]])

(defn counter-page []
  [:div [:h2 "counter"]
   [:div [:a {:href "/"} "index"]]
   [:div
    [:h3 @counter]
    [:button {:on-click up} "up"]
    [:button {:on-click down} "down"]]])

(defn todo-page []
  [:div [:h2 "todo"]
   [:div [:a {:href "/"} "index"]
    [:div (todo-app)]]])

(defn current-page []
  [:div [(session/get :current-page)]])

;; -------------------------
;; Routes

(secretary/defroute "/" []
  (session/put! :current-page #'home-page))

(secretary/defroute "/counter" []
  (session/put! :current-page #'counter-page))

(secretary/defroute "/todo" []
  (session/put! :current-page #'todo-page))

;; -------------------------
;; Initialize app

(defn mount-root []
  (r/render [current-page] (.getElementById js/document "app")))

(defn init! []
  (accountant/configure-navigation!)
  (accountant/dispatch-current!)
  (mount-root))
