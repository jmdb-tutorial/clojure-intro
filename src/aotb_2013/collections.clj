(ns aotb-2013.collections)

(def integers (range))

(take 20 integers)

(sort (take 20 integers)) ;; Sort them descending

;; Extract only odd numbers
(filter odd? (take 20 integers))

;; Filter out all odd numbers divisible by three
(filter (fn [x] (and (odd? x)
                    (= 3 x)))
        (take 20 integers))


;; Filter a map based on some function:
(def customers [
  {:is [:customer] :name "Billy F" :age 17 :height [270 :cm]}
  {:is [:customer] :name "Fred B"  :age 23 :height [256 :cm]}
  {:is [:customer] :name "Jenny J" :age 31 :height [260 :cm]}
  {:is [:customer] :name "Joan C"  :age 56 :height [280 :cm]}  
])


;; Filter out customers 
(defn between [x range]
  (let [[min max] range]
       (and (> x min)
            (< x max))))

(defn by-age-and-height [age-range height-range]
  (fn [customer] (let [{:keys [age height]} customer]
                  (and (between age age-range)
                       (between (first height) height-range)))))


(filter (by-age-and-height [15 60] [200 300]) customers)

(count (filter (by-age-and-height [15 60] [200 300]) customers))



