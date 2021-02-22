package xmlParsing.contacts

import groovy.text.SimpleTemplateEngine
import groovy.xml.XmlParser

def parser = new XmlParser()
def xml = parser.parse("contact.xml");
def fileTemplate = new File('contact.template')

def engine = new SimpleTemplateEngine()
Map binding = [ xml: xml]
def template = engine.createTemplate(fileTemplate).make(binding)

output = template.toString()
print output


