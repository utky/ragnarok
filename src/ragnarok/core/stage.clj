(ns ragnarok.core.stage)

(defrecord Act [id sections])

(defrecord Section [id subsections])

(def stage-template
  {:act1
   {:setup [:back-story :motivation :catalyst :central-question]
    :development [:preparetion]
    :turning-point []
    }
   :act2
   {:development []
    :midpoint []
    :turning-point []
    }
   :act3
   {:climax
    :resolution
    }
   })
