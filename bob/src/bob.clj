(ns bob
  (:require [clojure.string :as string]))

(defn remove_punc [str] (string/replace str #"[^\w+]" ""))

(defn yelling? [str] (every? #(or (or (Character/isLetter %)(Character/isDigit %))(Character/isUpperCase %))(remove_punc str)))

(defn response-for
  [cmd]
  (cond
    (string/blank? cmd) "Fine. Be that way!"
    (yelling? cmd) "Whoa, chill out!"
    (not (nil? (re-find #"\?$" cmd))) "Sure."
    :else "Whatever." ))
