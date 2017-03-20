(ns ragnarok.core.character)

; Interfaces
; --------------
; We should access to this domain by interface (protocol)

(def domain-keys
  [:tarot :zodiac :myth])

; シニフィエ的なもの
; 意味される概念
; 概念の表記としてキャラクタはある。
(defprotocol
  Concept)

; キャラクタの雛形を定める公理。
; 概念や主題に直結する。
; Archetypeが所属するドメインは様々である。
; 時には神話にその基礎を求めることもあるし、あるいは別の学問的体系かもしれない。
(defprotocol
  Archetype
  (concepts [this])
  (domain [this]))

; Actorはライフサイクルを持つ一つの存在。
; 複数の物語に参加することができる再利用可能な資源。(Subjectの意味が強いか？)
; キャラクターの意味であり役者の意味でもある。
; 時間の発展に従って年齢や種族などは変化していく。
; ただし時間を通じて変化しない属性をarchetypeとして備える。
(defprotocol
  Actor
  (archetypes [this]))

; 特定の物語に固定された役割を表す。
; 物語が変わればキャラクターの役割は変わっていくことを表現する。
; Protagonis, Antagonist, Supporter, etc...
(defprotocol
  Role)

(defprotocol
  Property)

(defprotocol
  Desire)

; Playerは物語中での役割を固定された表現。
; ある時間軸上での側面を持っていると考える。
; 行動に対する動機や制約
; playするための実行上の持ち場(role)がある。
(defprotocol
  Player
  (roles  [this])
  (actor [this]))

; Implementations
; --------------
; We should not depend on concrete structure defined below.

