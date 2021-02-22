package mailTemplate

import groovy.text.SimpleTemplateEngine

def smsTemplate = 'Dear <% print user %>, Thanks for reading our Article. ${signature}'
def bindMap = [user: "George", signature: "Panos"]
def smsText = new SimpleTemplateEngine().createTemplate(smsTemplate).make(bindMap)

println smsText.toString()

