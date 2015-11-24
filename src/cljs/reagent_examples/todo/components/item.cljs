(ns reagent-examples.todo.components.item)

(defn component [{:keys [id text completed]}]
  ^{:key id} [:li text])
