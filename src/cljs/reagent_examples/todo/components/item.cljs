(ns reagent-examples.todo.components.item)

(defn component [{:keys [id title]}]
  ^{:key id} [:li title])
