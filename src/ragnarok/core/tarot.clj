(ns ragnarok.core.tarot
  (:require [clj-yaml.core :as yaml]))

(defrecord Arcana
  [id name alias keywords])

(def tarots-base
  [[0 "The Fool" "道化" ["狂気" "霊感" "信頼" "狂熱"]]
   [1 "The Magician" "魔術師" ["質問者" "神" "権威" "駆引"]]
   [2 "The High Priestess" "女教皇" ["学問" "神秘" "瞑想" "平和"]]
   [3 "The Empress" "女帝" ["決断力" "行動" "愛" "家庭"]]
   [4 "The Emperor" "皇帝" ["意志" "摂理" "理性" "支配"]]
   [5 "The Hierophant" "法王" ["霊感" "指導" "司祭" "弁護人"]]
   [6 "The Lovers" "恋人" ["情熱" "自由" "結合" "一致"]]
   [7 "The Chariot" "戦車" ["勝利" "知性" "独立"]]
   [8 "Justice" "裁判の女神" ["正義" "責任" "公平"]]
   [9 "The Hermit" "隠者" ["智恵" "身長" "秘伝"]]
   [10 "Wheel of Fortune" "運命の輪" ["運命" "時間" "恩寵" "幸運"]]
   [11 "Strength" "女力士" ["力" "仕事" "勇気" "忍耐"]]
   [12 "The Hanged Man" "刑死者" ["犠牲" "試練" "規律" "服従"]]
   [13 "Death" "死神" ["死" "再生" "永続" "人間性"]]
   [14 "Temperance" "節制" ["倹約" "中庸" "純潔" "平静"]]
   [15 "The Devil" "悪魔" ["病気" "暴力" "衝動" "粗暴"]]
   [16 "The Tower" "落雷の塔" ["破滅" "失望" "罰" "屈辱"]]
   [17 "The Star" "星" ["希望" "天体の感応" "雄弁"]]
   [18 "The Moon" "月" ["危険" "敵" "裏切り" "偽りの友"]]
   [19 "The Sun" "太陽" ["結婚" "幸福" "発見" "天啓"]]
   [20 "The Judgement" "審判" ["錬金術" "変化" "覚醒" "驚異"]]
   [21 "The World" "世界" ["成功" "調和" "満足" "完全"]]])

(def major-arcana
  (map #(apply ->Arcana %) tarots-base))

(def suit
  [[1 "wands" "杖" ["火"]]
   [2 "swords" "剣" ["風"]]
   [3 "cups" "聖杯" ["水"]]
   [4 "coins" "金貨" ["地"]]
   ])

(def pip
  (map
    (fn [v]
      (let [vs (str v)]
        (->Arcana v vs vs [])))
    (range 1 11)))

(def court
  (map
    (fn [[v k a]]
      (let [vs (str v)]
        (->Arcana v k a [])))
    [[11 "Page" "小姓"]
     [12 "Knight" "騎士"]
     [13 "Queen" "女王"]
     [14 "King" "王"]]))

; Minor works as flavor or suppliment
(def minor-arcana 
  (concat pip court))

(def card-slots
  [:protagonist :antagonist :sender :object :receiver :supporter])

(defn gen-seeds
  []
  (shuffle (range (count major-arcana))))

(defn make-slots
  "receive random indice"
  [seeds]
  (->> (map vector card-slots seeds)
       (reduce
         (fn [m [l s]]
           (assoc m l (nth major-arcana s)))
         {})))

(defn sample
  []
  (println (yaml/generate-string (make-slots (gen-seeds)))))

