package mailTemplate

import groovy.text.XmlTemplateEngine

def emailXmlTemplate = '''
<xs xmlns:gsp='groovy-server-pages'>
    <gsp:scriptlet>def emailContent = "Thanks for subscribing our services."</gsp:scriptlet>
    <email>
        <greet>Dear ${user}</greet>
        <content><gsp:expression>emailContent</gsp:expression></content>
        <signature>${signature}</signature>
    </email>
</xs>'''

def bindMap = [user: "Norman", signature: "Baeldung"]
def emailXml = new XmlTemplateEngine().createTemplate(emailXmlTemplate).make(bindMap)

println emailXml.toString()