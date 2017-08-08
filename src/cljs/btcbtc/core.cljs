(ns btcbtc.core
  (:require
   [reagent.core :as reagent]
   ))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Vars

(defonce app-state
  (reagent/atom {}))

(defn text-item [title description icon-name]
          [:div.bgrid.item
           [:span.icon [:i {:class (str "icon-" icon-name)}]]
           [:div.item-content
            [:h3.h05 title]
            [:p description
             ]]])


(def text {
  :page-top "How to bulid (or use) your secure, discrete and legal e-commerce network?"
  :page-top-description "Mathias Grey: Your guide to the grey zone"
  :btc-accept "ACCEPTED HERE"     
  :placeholder-name "Name"     
  :placeholder-email "Email"     
  :placeholder-subject "Who recomended me?"     
  :placeholder-message "Define your question or issue"     
  :send-message "Send"
  :sending "Sending..."
  :tab-title-1 "About"
  :tab-subtitle-1 "Introduction"
  :tab-lead-1 "Hi, my name is Mathias. I have serious experience on selling legal products, wich needs discretion.
   Now I share my knowledge and provide consulting.
   I learned my own skin, the pitfalls of gray e-commerce, but never condemned."
  :about-section [:div.about-list.block-1-3.block-s-1-2.block-tab-full
          [text-item 
           "What is grey e-commerce?"
             [:p "There is multiple different usage of the term \"grey commerce\":" 
			 [:br] "1, If a product is not illegal" 
			 [:br]	"but needs discretion."
			 [:br][:br] "2, If a product is not illegal, and a certain social,religious, or political group intent prohibit, but the regulation is unclear."
			 [:br][:br] "3, If a prdouct is legal, but  interests of certain economic or social groups are violated by the source of procurement."
			 ]
           "info"
           ]
          [text-item 
           "Prices"
             [:p "Deposit for scheulde consultation time:"
		  	 [:br]"250 USD in BTC"
			 [:br]"Additional fee:"
			 [:br][:b"50-200 USD/hour in BTC"] 
			 [:br]"(depending on the issue, and the client's background)."
			 ]
           "dollar"
           ]
          [text-item 
           "Legal Disclosure"
            [:p "- Mathias Gray Consulting does not disclose information to third parties."
			[:br]"- Mathias Gray Consulting is solely for legal or other business purposes."
			[:br]"- Mathias Gray Consulting does not support any violation of any applicable law."
			[:br]"- The consultation and all the services provided by Mathias Gray Consulting only serve educational purposes."
			[:br]"- Mathias Gray Consulting is not responsible for any liability of its clients for violating the law."
			]
	    "scales"
           ]]
  :tab-title-2 "Contact me"
  :tab-subtitle-2 "How this thing works?"
  :tab-lead-2 "Write me a message, verify yourself and describe your issue/question. If I will think that we will be able to work together, I will send you a BTC adress where you can pay for the deposit and reserve a timeframe for the consultation, witch could have additional fees."
  :tab-title-3 "Testimony"
  :tab-subtitle-3 ""
  :tab-lead-3 ""
    :about-section-3 [:div.about-list.block-1-3.block-s-1-2.block-tab-full
          [text-item 
           "Pedro69"
             [:p "I had erectile dysfunction, and my marriage went in danger."
			  "In my country is very difficult to access proper medication, and the regulation is unclear."
			  "Mathias taught me how can I access to the right supplier, with full discretion and security."
			 ]
           "heart"
           ]
          [text-item 
           "Munḥarif"
             [:p "I'm homosexual, but I moved to Saudi Arabia because of my work...where this is a sin (\"halal\"). "
			 "Gay sex toys or DVD's are prohibited by the \"sharia\" but there is a smart way to get them.;) "
			 "Mathias helped me a lot about learning the basics of online discretion."
			 ]
           "skull"
           ]
          [text-item 
           "Tiara"
            [:p "I have been admitted to a foreign top University. Hurray!" 
			[:br]"The only problem is that I can't access here to my prescribed medication, and I have learning disabilities." 
			"Right now I can fulfill the requirements without meds but in the case, I would struggle I will not panic. THX Mathias!." 
			  ]
	  "education"
           ]]
           :footer-text ""
           :footer-text-link ""
           :back-to-top "Back To Top"
           })


(defn btc-accept []
[:div.pay-with-btc
     [:a {:href "#"}]
     [:div.logo
           [:div.coin [:center [:i.fa.fa-btc]]]
           [:div.glare.logo-text.masked "bitcoin "]
           [:div.accept (:btc-accept text)]]])

(defn btc []
[:div [:div.bitcoin
  [:img {:align "center" :src "images/Bitcoin_logo.png"}]]
[:div.shadow]])

(defn counter []
       [:div#counter
        [:div.half
         [:span "334 " [:sup "days"]]
         [:span "23 " [:sup "hours"]]]
        [:div.half
         [:span "50 " [:sup "mins"]]
         [:span "33 " [:sup "secs"]]]])

(defn welcome-text []
[:div.bottom-text
        [:h1 (:page-top text)]
        [:p (:page-top-description text)]])

(defn scroll-down []
[:div.scroll-icon
       [:a.smoothscroll {:href "#info"}]
       [:div.mouse]
       [:div.end-top]])

(defn section-home []
  [:section#home.home-particles
   [:div.shadow-overlay]
   [:div.content-wrap-table
    [:div.main-content-tablecell
     [:div.row
      [:div.col-twelve
      ; [counter]
       [btc]
       [welcome-text]]
      [scroll-down]]]]])

(defn form-wrap []
[:div.row.form-wrap.tab-entry-content
     [btc-accept]
         [:div.col-twelve
          [:form#contactForm
           {:action "", :method "post", :name "contactForm"}
           [:fieldset
            [:div.form-field
             [:input#contactName
              {:required true
               :minlength "2",
               :placeholder (:placeholder-name text)
               :type "text",
               :name "contactName"}]]
            [:div.form-field
             [:input#contactEmail
              {:required true
               :placeholder (:placeholder-email text)
               :type "email",
               :name "contactEmail"}]]
            [:div.form-field
             [:input#contactSubject
              {:placeholder (:placeholder-subject text)
               :type "text",
               :name "contactSubject"}]]
            [:div.form-field
             [:textarea#contactMessage
              {:required true
               :cols "50",
               :rows "10",
               :placeholder (:placeholder-message text)
               :name "contactMessage"}]]
            [:div.form-field
             [:button.submitForm.button.button-primary.large
              (:send-message text)]
             [:div#submit-loader
              [:div.text-loader 
               (:sending text)]
              [:div.s-loader
               [:div.bounce1]
               [:div.bounce2]
               [:div.bounce3]]]]]]
          [:div#message-warning]
          [:div#message-success
           [:i.fa.fa-check]
           "Sent!"
           [:br]]]])


(defn tabs-wrap []
[:div.col-twelve.tabs-wrap
     [:ul.tabs
      [:li.active
       {:data-id "tab-about"}
       [:i.icon-eye]
       [:span (:tab-title-1 text)]]
      [:li
       {:data-id "tab-contact"}
       [:i.icon-mail]
       [:span (:tab-title-2 text)]]
      [:li
       {:data-id "tab-law"}
       [:i.icon-smile]
       [:span (:tab-title-3 text)]]]
     [:div.tab-container
      [:div#tab-about.tab-content
       [:div.tab-entry
        [:div.row.tab-entry-intro
         [:div.col-twelve.with-bottom-line
          [:h1 (:tab-subtitle-1 text)]
          [:p.lead (:tab-lead-1 text)]]]
        [:div.row.about-content.tab-entry-content
         (:about-section text)]]]
      [:div#tab-contact.tab-content
       [:div.tab-entry
        [:div.row.tab-entry-intro
         [:div.col-twelve.with-bottom-line
          [:h1 (:tab-subtitle-2 text)]
          [:p.lead (:tab-lead-2 text)]]]
        [form-wrap]]]
      [:div#tab-law.tab-content
       [:div.tab-entry
        [:div.row.tab-entry-intro
         [:div.col-twelve.with-bottom-line
          [:h1 (:tab-subtitle-3 text)]
          [:p.lead (:tab-lead-3 text)]]]
		[:div.row.about-content.tab-entry-content
         (:about-section-3 text)]
      ]]
     ]])


(defn section-info []
  [:section#info
   [:div.info-overlay]
   [:div.row
    [tabs-wrap]]])

(defn section-cta []
  [:section#cta
   [:div.row.cta-wrap
    [:div.col-twelve.cta-content
     [:h2.h01 [:a {:href "#top"} "Pay with BTC"]]
     [:p.lead
      "Fizetnél bitcoinnal? Try "
      [:a {:href ""} [:span ""]]
      "Fizess " [:span "20% discount"]
      " bitcoinnal "
      [:span "now"]"."]
     [:div.action [:a.button.large {:href "#"} "PAAY"]]]]])

(defn social-links []
[:div.social-links
    [:ul
     [:li [:a {:href "#"} [:i.fa.fa-twitter]]]
     ]])

(defn social-wrap []
   [:div.social-wrap
    [:div.row
     [:ul.footer-social-list
      [:li [:a {:href "#"} [:i.fa.fa-twitter] [:span "Twitter"]]]
      ]]])

(defn footer-button []
   [:div.footer-bottom
    [:div.footer-logo
     [:img {:alt "" :src "images/footer-logo.png"}]]
    [:div.copyright
     [:span [:a {:href (:footer-text-link text)} (:footer-text text)]]]])

(defn back-to-top []
[:div.back-to-top
    [:a.smoothscroll {:href "#top"} [:span (:back-to-top text)]]])

;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Page

(defn page [app-state]
[:div.root
 [:header
  [:div.row
   [:div.logo [:a {:href "index.html"} "Unknown"]]
   ;[social-links]
   ]]
  [section-home]
  [section-info]
  ;[section-cta]
  [:footer
   ;[social-wrap]
   [footer-button]
   [back-to-top]]])




(defn origin [ratom]
  [:div
   "Welcome to reagent-figwheel."])



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Initialize App

(defn dev-setup []
  (when ^boolean js/goog.DEBUG
    (enable-console-print!)
    (println "dev mode")
    ))

(defn reload []
  (reagent/render [page app-state]
                  (.getElementById js/document "app")))

(defn ^:export main []
  (dev-setup)
  (reload))

