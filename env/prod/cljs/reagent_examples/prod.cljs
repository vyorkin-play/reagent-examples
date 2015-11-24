(ns reagent-examples.prod
  (:require [reagent-examples.core :as core]))

;;ignore println statements in prod
(set! *print-fn* (fn [& _]))

(core/init!)
