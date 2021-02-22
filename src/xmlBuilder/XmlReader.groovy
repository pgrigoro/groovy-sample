package xmlBuilder

import groovy.xml.XmlSlurper
import groovy.xml.XmlParser

def xml = """
<langs type='current' count='2' mainstream='true'>
  <language type='static' version='11'>Java</language>
  <language type='dynamic' version='3.0.7'>Groovy</language>
</langs>
"""

def langs = new XmlParser().parseText(xml)
println langs.attribute("count")
langs.language.each{
    println it.text()
}

langs = new XmlSlurper().parseText(xml)
println langs.@count
langs.language.each{
    println it
}
