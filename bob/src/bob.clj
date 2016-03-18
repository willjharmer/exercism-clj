(ns bob
  (:require [clojure.string :as string]))

(defn remove_punc 
  [str] 
  (string/replace str #"[^A-Za-z]" ""))

(defn yelling? 
  [str]
  (and (not (string/blank? (remove_punc str))) 
  (every? #(Character/isUpperCase %)(remove_punc str))))

(defn response-for
  [cmd]
  (cond
    (string/blank? cmd) "Fine. Be that way!"
    (yelling? cmd) "Whoa, chill out!"
    (string/ends-with? cmd "?") "Sure."
    :else "Whatever." ))
